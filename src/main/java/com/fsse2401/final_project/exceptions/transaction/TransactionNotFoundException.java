package com.fsse2401.final_project.exceptions.transaction;

public class TransactionNotFoundException extends RuntimeException {

    public TransactionNotFoundException(Integer tid, String firebaseUid) {
        super("Transaction (tid= " + tid + ") Not Found, firebaseUid= " + firebaseUid);
    }
}
