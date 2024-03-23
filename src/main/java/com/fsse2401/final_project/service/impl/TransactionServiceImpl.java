package com.fsse2401.final_project.service.impl;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.product.entity.ProductEntity;
import com.fsse2401.final_project.data.transaction.TransactionStatus;
import com.fsse2401.final_project.data.transaction.domainObject.TransactionResponseData;
import com.fsse2401.final_project.data.transaction.entity.TransactionEntity;
import com.fsse2401.final_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import com.fsse2401.final_project.exceptions.product.ProductOutOfStockException;
import com.fsse2401.final_project.exceptions.transaction.EmptyTransactionProdcutException;
import com.fsse2401.final_project.exceptions.transaction.InvalidTransactionStatusException;
import com.fsse2401.final_project.exceptions.transaction.TransactionNotFoundException;
import com.fsse2401.final_project.repository.TransactionRepository;
import com.fsse2401.final_project.service.*;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    final private UserService userService;
    final private CartItemService cartItemService;
    final private TransactionProductService transactionProductService;
    final private TransactionRepository transactionRepository;
    final private ProductService productService;

    @Autowired
    public TransactionServiceImpl(UserService userService, CartItemService cartItemService, TransactionProductService transactionProductService, TransactionRepository transactionRepository, ProductService productService) {
        this.userService = userService;
        this.cartItemService = cartItemService;
        this.transactionRepository = transactionRepository;
        this.transactionProductService = transactionProductService;
        this.productService = productService;
    }

    @Override
    public TransactionResponseData createATransaction(FirebaseUserData firebaseUserData) {
        UserEntity user = userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartItemEntity> userCart = cartItemService.findByUserEntity(user);
        if (userCart.isEmpty()) throw new EmptyTransactionProdcutException(user.getUid());
        // check all product is in stock before creating transaction
        for (CartItemEntity cartItem : userCart) {
            if (productService.outOfStock(cartItem.getProduct(), cartItem.getQuantity()))
                throw new ProductOutOfStockException(cartItem.getProduct().getPid());
        }
        //  when it’s saving the “non-owning” side (transactionProduct) Entity in the db.
        //  database needs that foreign key (tid) to be present (transaction) first, transaction's tid only auto generated after .save();
        TransactionEntity newTransaction = transactionRepository.save(new TransactionEntity(user));
        // manually sync the non-owing side(Parent)'s Child Entity also calculate total, in Java Object Model layer
        newTransaction.setItems(transactionProductService.createTransactionProducts(newTransaction, userCart));
        return new TransactionResponseData(transactionRepository.save(newTransaction));
    }

    @Override
    public TransactionResponseData getTransactionById(FirebaseUserData firebaseUserData, Integer tid) {
        // check if transaction(tid) exist AND belongs to current User
        TransactionEntity transaction = getEntityByTidAndFirebaseUid(tid, firebaseUserData.getFirebaseUid());
        return new TransactionResponseData(transaction);
    }

    @Override
    public void processTransaction(FirebaseUserData firebaseUserData, Integer tid) {
        // check if transaction(tid) exist AND belongs to current User
        TransactionEntity transaction = getEntityByTidAndFirebaseUid(tid, firebaseUserData.getFirebaseUid());
        // check if the transaction is in "PREPARE" State
        if (transaction.getStatus() != TransactionStatus.PREPARE)
            throw new InvalidTransactionStatusException(tid, transaction.getStatus());
        // check for current product stock is enough for ALL transactionProduct's quantity
        List<TransactionProductEntity> transactionProductEntities = transaction.getItems();
        List<ProductEntity> productsStockToBeDeduced = new ArrayList<>();
        for (TransactionProductEntity transactionProduct : transactionProductEntities) {
            ProductEntity product = productService.getProductById(transactionProduct.getPid());
            if (productService.outOfStock(product, transactionProduct.getQuantity()))
                throw new ProductOutOfStockException(transactionProduct.getPid(), tid);
            productsStockToBeDeduced.add(product);
        }
        //  confirmed every product in stock, deduce each product stock and save product
        //     (reduce query productEntity again, arraylist is sequential)
        for (int i = 0; i < productsStockToBeDeduced.size(); i++) {
            ProductEntity product = productsStockToBeDeduced.get(i);
            product.setStock(product.getStock() - transactionProductEntities.get(i).getQuantity());
        }
        productService.saveAllProducts(productsStockToBeDeduced);
        transaction.setStatus(TransactionStatus.PROCESSING);
        transactionRepository.save(transaction);
    }

    @Override
    @Transactional // rollback to avoid cartItemEntity deleted from db, but transaction error occur (e.g. db disconnect)
    public TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, Integer tid) {
        //Optional<TransactionEntity> transactionOptional = transactionRepository.findById(tid);
        TransactionEntity transaction = getEntityByTidAndFirebaseUid(tid, firebaseUserData.getFirebaseUid());
        // check if transaction in "PROCESSING" state
        if (transaction.getStatus() != TransactionStatus.PROCESSING)
            throw new InvalidTransactionStatusException(tid, transaction.getStatus());
        transaction.setStatus(TransactionStatus.SUCCESS);
        // empty the cart: delete all cart items of current user
        cartItemService.deleteAll(cartItemService.findByUserEntity(transaction.getUser()));
        return new TransactionResponseData(transactionRepository.save(transaction));
    }

    @Override
    public TransactionEntity getEntityByTidAndFirebaseUid(Integer tid, String firebaseUid) {
        return transactionRepository.findByTidAndUser_FirebaseUid(tid, firebaseUid)
                .orElseThrow(() -> new TransactionNotFoundException(tid, firebaseUid));
    }
}
