package com.fsse2401.final_project.service;

import com.fsse2401.final_project.data.cartItem.CartStatus;
import com.fsse2401.final_project.data.cartItem.domainObject.CartItemResponseData;
import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;

import java.util.List;

public interface CartItemService {
    CartStatus putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity);

    List<CartItemResponseData> getCartItems(FirebaseUserData firebaseUserData);

    CartItemResponseData updateCartItemQty(FirebaseUserData firebaseUserData, Integer pid, Integer newQuantity);

    CartStatus removeCartItem(FirebaseUserData firebaseUserData, Integer pid);
}
