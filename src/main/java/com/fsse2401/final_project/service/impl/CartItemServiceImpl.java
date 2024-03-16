package com.fsse2401.final_project.service.impl;

import com.fsse2401.final_project.data.cartItem.CartStatus;
import com.fsse2401.final_project.data.cartItem.domainObject.CartStatusResponseData;
import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.product.entity.ProductEntity;
import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import com.fsse2401.final_project.exceptions.product.ProductNotFoundException;
import com.fsse2401.final_project.repository.CartItemRepository;
import com.fsse2401.final_project.repository.ProductRepository;
import com.fsse2401.final_project.service.CartItemService;
import com.fsse2401.final_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    @Autowired
    public CartItemServiceImpl(UserService userService, CartItemRepository cartItemRepository, ProductRepository productRepository) {
        this.userService = userService;
        this.cartItemRepository = cartItemRepository;
        this.productRepository = productRepository;
    }

    @Override
    public CartStatusResponseData putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity) {
        if (quantity <= 0) return new CartStatusResponseData(CartStatus.REJECTED);
        ProductEntity productEntity = productRepository.findById(pid)
                .orElseThrow(() -> new ProductNotFoundException(pid));
        if (!hasEnoughStock(quantity, productEntity))
            return new CartStatusResponseData(CartStatus.REJECTED);
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
        Optional<CartItemEntity> cartItemEntityOptional = cartItemRepository
                .findCartItemByUserAndProduct(userEntity.getUid(), productEntity.getPid());
        if (cartItemEntityOptional.isPresent()) {
            CartItemEntity cartItem = cartItemEntityOptional.get();
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItemRepository.save(cartItem);
        }else{
            cartItemRepository.save(new CartItemEntity(quantity, userEntity, productEntity));
        }
        productEntity.setStock(productEntity.getStock() - quantity);
        productRepository.save(productEntity);
        return new CartStatusResponseData(CartStatus.SUCCESS);
    }

    boolean hasEnoughStock(Integer quantity, ProductEntity productEntity) {
        return productEntity.getStock() >= quantity;
    }
}
