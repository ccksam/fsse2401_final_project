package com.fsse2401.final_project.data.cartItem.domainObject;

import com.fsse2401.final_project.data.cartItem.CartStatus;

public class CartStatusResponseData {
    private CartStatus result;

    public CartStatusResponseData(CartStatus status) {
        this.result = status;
    }

    public CartStatus getResult() {
        return result;
    }

    public void setResult(CartStatus result) {
        this.result = result;
    }
}
