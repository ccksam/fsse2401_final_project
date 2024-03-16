package com.fsse2401.final_project.service.impl;

import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import com.fsse2401.final_project.service.CartItemService;
import com.fsse2401.final_project.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemServiceImpl implements CartItemService {
    private final UserService userService;

    @Autowired
    public CartItemServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void putCartItem(FirebaseUserData firebaseUserData, Integer pid, Integer quantity) {
        UserEntity userEntity = userService.getEntityByFirebaseUserData(firebaseUserData);
    }
}
