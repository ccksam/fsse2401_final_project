package com.fsse2401.final_project.data.cartItem.dto;


import com.fsse2401.final_project.data.cartItem.CartStatus;
import lombok.Getter;

@Getter
public class CartStatusResponseDto {
    // jackson lib serialized enum constant as string by default
    private CartStatus status;

    public CartStatusResponseDto(CartStatus status) {
        setStatus(status);
    }

    private void setStatus(CartStatus status) {
        this.status = status;
    }
}
