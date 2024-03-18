package com.fsse2401.final_project.data.cartItem.dto;


import com.fsse2401.final_project.data.cartItem.CartStatus;

public class CartStatusResponseDto {
    private CartStatus status;

    public CartStatusResponseDto(CartStatus status) {
        setStatus(status);
    }

    // jackson lib serialized enum constant as string by default
    public CartStatus getStatus() {
        return status;
    }

    private void setStatus(CartStatus status) {
        this.status = status;
    }
}
