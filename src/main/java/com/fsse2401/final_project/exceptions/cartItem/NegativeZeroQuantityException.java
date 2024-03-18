package com.fsse2401.final_project.exceptions.cartItem;

public class NegativeZeroQuantityException extends RuntimeException {
    public NegativeZeroQuantityException() {
        super("Negative or Zero Cart Item Quantity Exception");
    }
}
