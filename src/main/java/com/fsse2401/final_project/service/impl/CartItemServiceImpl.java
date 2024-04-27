package com.fsse2401.final_project.service.impl;

import com.fsse2401.final_project.data.cartItem.CartStatus;
import com.fsse2401.final_project.data.cartItem.domainObject.CartItemResponseData;
import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.product.entity.ProductEntity;
import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import com.fsse2401.final_project.exceptions.cartItem.CartItemNotExistException;
import com.fsse2401.final_project.exceptions.cartItem.NegativeZeroQuantityException;
import com.fsse2401.final_project.exceptions.product.ProductOutOfStockException;
import com.fsse2401.final_project.repository.CartItemRepository;
import com.fsse2401.final_project.service.CartItemService;
import com.fsse2401.final_project.service.ProductService;
import com.fsse2401.final_project.service.UserService;
import com.fsse2401.final_project.utils.CartItemDataUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;
    private final ProductService productService;
    private final CartItemRepository cartItemRepository;

    @Autowired
    public CartItemServiceImpl(UserService userService, ProductService productService, CartItemRepository cartItemRepository) {
        this.userService = userService;
        this.productService = productService;
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartStatus putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity) {
        if (quantity <= 0) throw new NegativeZeroQuantityException();
        ProductEntity productEntity = productService.getProductById(pid);
        if (productService.outOfStock(productEntity, quantity)) throw new ProductOutOfStockException(pid);
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        Optional<CartItemEntity> cartItemEntityOptional = cartItemRepository.findCartItemByUserAndProduct(userEntity.getUid(), productEntity.getPid());
        if (cartItemEntityOptional.isPresent()) {
            CartItemEntity cartItem = cartItemEntityOptional.get();
            if (productService.outOfStock(productEntity, quantity + cartItem.getQuantity()))
                throw new ProductOutOfStockException(pid);
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItemRepository.save(cartItem);
        } else {
            cartItemRepository.save(new CartItemEntity(quantity, userEntity, productEntity));
        }
        return CartStatus.SUCCESS;
    }

    @Override
    public List<CartItemResponseData> getCartItems(FirebaseUserData firebaseUserData) {
        // always get and save user entity to db, even empty cart.
        UserEntity user = userService.getEntityByFirebaseUserData(firebaseUserData);
        // alternate query: same result
        //1. List<CartItemEntity> cartItems = cartItemRepository.findByUserUid(userService.getEntityByFirebaseUserData(firebaseUserData).getUid());
        //2. List<CartItemEntity> cartItems = cartItemRepository.findByUser(userService.getEntityByFirebaseUserData(firebaseUserData));
        List<CartItemEntity> cartItems = cartItemRepository.findByUser_FirebaseUid(user.getFirebaseUid());
        return CartItemDataUtils.toCartItemData(cartItems);
    }

    @Override
    public CartItemResponseData updateCartItemQty(FirebaseUserData firebaseUserData, Integer pid, Integer newQuantity) {
        if (newQuantity < 0) throw new NegativeZeroQuantityException();
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        Optional<CartItemEntity> cartItemEntityOptional = cartItemRepository.findCartItemByUserAndProduct(userEntity.getUid(), pid);
        if (cartItemEntityOptional.isPresent()) {
            CartItemEntity cartItem = cartItemEntityOptional.get();
            if (productService.outOfStock(cartItem.getProduct(), newQuantity))
                throw new ProductOutOfStockException(pid);
            cartItem.setQuantity(newQuantity);
            return new CartItemResponseData(cartItemRepository.save(cartItem));
        } else {
            throw new CartItemNotExistException(pid);
        }
    }

    @Override
    // .TransactionRequiredException if not include, ensuring that the deleteByUser_FirebaseUidAndProduct_Pid operation is executed within a transaction.
    @Transactional
    public CartStatus removeCartItem(FirebaseUserData firebaseUserData, Integer pid) {
        if (cartItemRepository.deleteByUser_FirebaseUidAndProduct_Pid(firebaseUserData.getFirebaseUid(), pid) <= 0) {
            throw new CartItemNotExistException(pid);
        }
        return CartStatus.SUCCESS;
    }

    @Override
    public List<CartItemEntity> findByUserEntity(UserEntity userEntity) {
        return cartItemRepository.findByUser(userEntity);
    }

    @Override
    public void deleteAll(List<CartItemEntity> cartItemEntities) {
        cartItemRepository.deleteAll(cartItemEntities);
    }
}
