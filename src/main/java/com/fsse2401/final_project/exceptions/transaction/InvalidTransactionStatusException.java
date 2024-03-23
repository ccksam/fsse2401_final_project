package com.fsse2401.final_project.exceptions.transaction;

import com.fsse2401.final_project.data.transaction.TransactionStatus;

public class InvalidTransactionStatusException extends RuntimeException {
    private String detailMessage;

    public InvalidTransactionStatusException(Integer tid, TransactionStatus status) {
        super();
        StackTraceElement[] stackTrace = this.getStackTrace();
        if (stackTrace.length > 0) {
            this.detailMessage = stackTrace[0].getMethodName();
        }
        detailMessage += ":(tid: " + tid + ") in "
                + status + " is not allowed for current operation";
    }

    @Override
    public String getMessage() {
        return this.detailMessage;
    }
}
