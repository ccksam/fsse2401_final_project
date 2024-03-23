package com.fsse2401.final_project.exceptions.handlers;

import com.fsse2401.final_project.exceptions.ResponseBody;
import com.fsse2401.final_project.exceptions.transaction.EmptyTransactionProdcutException;
import com.fsse2401.final_project.exceptions.transaction.TransactionNotFoundException;
import com.fsse2401.final_project.exceptions.transaction.InvalidTransactionStatusException;
import com.fsse2401.final_project.exceptions.transaction.TransactionUserMismatchException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalTransactionExceptionHandler {
    final private static Logger logger = LoggerFactory.getLogger(GlobalTransactionExceptionHandler.class);

    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<ResponseBody> handleTransactionNotFoundException(TransactionNotFoundException e) {
        logger.warn(e.getMessage());
        ResponseBody exResponseBody = new ResponseBody(HttpStatus.NOT_FOUND.toString(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exResponseBody);
    }

    @ExceptionHandler(TransactionUserMismatchException.class)
    public ResponseEntity<ResponseBody> handleTransactionUserMismatchException(TransactionUserMismatchException e) {
        logger.warn(e.getMessage());
        ResponseBody exResponseBody = new ResponseBody(HttpStatus.FORBIDDEN.toString(), HttpStatus.FORBIDDEN.value());
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exResponseBody);
    }

    @ExceptionHandler(InvalidTransactionStatusException.class)
    public ResponseEntity<ResponseBody> handleTransactionNotProcessingException(InvalidTransactionStatusException e) {
        logger.warn(e.getMessage());
        ResponseBody exResponseBody = new ResponseBody(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponseBody);
    }

    @ExceptionHandler(EmptyTransactionProdcutException.class)
    public ResponseEntity<ResponseBody> handleEmptyTransactionProdcutException(EmptyTransactionProdcutException e) {
        logger.warn(e.getMessage());
        ResponseBody exResponseBody = new ResponseBody(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponseBody);
    }
}
