package com.fsse2401.final_project.service.impl;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.transaction.domainObject.TransactionResponseData;
import com.fsse2401.final_project.data.transaction.entity.TransactionEntity;
import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import com.fsse2401.final_project.repository.TransactionRepository;
import com.fsse2401.final_project.service.CartItemService;
import com.fsse2401.final_project.service.TransactionProductService;
import com.fsse2401.final_project.service.TransactionService;
import com.fsse2401.final_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {
    final private UserService userService;
    final private CartItemService cartItemService;
    final private TransactionProductService transactionProductService;
    final private TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(UserService userService,
                                  CartItemService cartItemService,
                                  TransactionProductService transactionProductService,
                                  TransactionRepository transactionRepository) {
        this.userService = userService;
        this.cartItemService = cartItemService;
        this.transactionRepository = transactionRepository;
        this.transactionProductService = transactionProductService;
    }

    @Override
    public TransactionResponseData createATransaction(FirebaseUserData firebaseUserData) {
        UserEntity user = userService.getEntityByFirebaseUserData(firebaseUserData);
        List<CartItemEntity> userCart = cartItemService.findByUserEntity(user);
        // database needs that foreign key (tid) to be present (transaction) first
        //  when it’s saving the “non-owning” side (transactionProduct)
        //     transaction's tid only auto generated after .save();
        TransactionEntity newTransaction = transactionRepository.save(new TransactionEntity(user));
        // manually sync the non-owing side(Parent)'s Child Entity, in Java Object Model layer
        newTransaction.setItems(
                transactionProductService.createTransactionProducts(newTransaction, userCart)
        );
        return new TransactionResponseData(transactionRepository.save(newTransaction));
    }
}
