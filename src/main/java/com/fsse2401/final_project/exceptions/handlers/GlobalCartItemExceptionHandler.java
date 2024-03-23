package com.fsse2401.final_project.exceptions.handlers;

import com.fsse2401.final_project.exceptions.ResponseBody;
import com.fsse2401.final_project.exceptions.cartItem.CartItemNotExistException;
import com.fsse2401.final_project.exceptions.cartItem.NegativeZeroQuantityException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalCartItemExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalCartItemExceptionHandler.class);

    @ExceptionHandler(NegativeZeroQuantityException.class)
    public ResponseEntity<ResponseBody> handleNegativeZeroQuantityException(NegativeZeroQuantityException e) {
        logger.warn(e.getMessage());
        ResponseBody exResponseBody = new ResponseBody(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponseBody);
    }

    @ExceptionHandler(CartItemNotExistException.class)
    public ResponseEntity<ResponseBody> handleCartItemNotExistException(CartItemNotExistException e) {
        logger.warn(e.getMessage());
        ResponseBody exResponseBody = new ResponseBody(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponseBody);
    }
}

