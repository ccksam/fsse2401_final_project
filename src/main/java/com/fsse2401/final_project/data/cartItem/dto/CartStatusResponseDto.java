package com.fsse2401.final_project.data.cartItem.dto;

import com.fsse2401.final_project.data.cartItem.CartStatus;
import com.fsse2401.final_project.data.cartItem.domainObject.CartStatusResponseData;
import jakarta.persistence.Enumerated;

public class CartStatusResponseDto {
    private CartStatus result;

    public CartStatusResponseDto(CartStatusResponseData cartStatusResData) {
        this.result = cartStatusResData.getResult();
    }

    // jackson lib serialized enum constant as string by default
    public CartStatus getResult() {
        return result;
    }

    public void setResult(CartStatus result) {
        this.result = result;
    }
}
