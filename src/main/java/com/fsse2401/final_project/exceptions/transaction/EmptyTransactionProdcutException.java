package com.fsse2401.final_project.exceptions.transaction;

public class EmptyTransactionProdcutException extends RuntimeException {

    public EmptyTransactionProdcutException(Integer uid) {
        super(String.format("User (uid: %d) cart is empty", uid));
    }
}
