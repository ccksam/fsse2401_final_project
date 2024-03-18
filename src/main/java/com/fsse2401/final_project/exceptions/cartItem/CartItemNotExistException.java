package com.fsse2401.final_project.exceptions.cartItem;

public class CartItemNotExistException extends RuntimeException {
    public CartItemNotExistException(Integer pid) {
        super(String.format("PATCH FAIL: cartItem pid(%d) NOT EXIST", pid));
    }
}
