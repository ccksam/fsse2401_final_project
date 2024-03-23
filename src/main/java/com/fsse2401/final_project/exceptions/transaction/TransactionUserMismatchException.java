package com.fsse2401.final_project.exceptions.transaction;

public class TransactionUserMismatchException extends RuntimeException {

    public TransactionUserMismatchException(Integer tid, Integer uid) {
        super(String.format("Transaction (tid: %d) not belong to User (uid: %d)", tid, uid));
    }
}
