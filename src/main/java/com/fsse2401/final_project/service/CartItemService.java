package com.fsse2401.final_project.service;

import com.fsse2401.final_project.data.cartItem.domainObject.CartStatusResponseData;
import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;

public interface CartItemService {
    CartStatusResponseData putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity);
}
