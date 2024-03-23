package com.fsse2401.final_project.exceptions.handlers;

import com.fsse2401.final_project.exceptions.ResponseBody;
import com.fsse2401.final_project.exceptions.product.ProductNotFoundException;
import com.fsse2401.final_project.exceptions.product.ProductOutOfStockException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalProductExceptionHandler {
    private final static Logger logger = LoggerFactory.getLogger(GlobalProductExceptionHandler.class);

    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<ResponseBody> handleTypeMismatchException(TypeMismatchException e) {
        logger.warn(e.getMessage());
        ResponseBody exResponseBody = new ResponseBody("Invalid Path Variables", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponseBody);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseBody> handleProductNotFoundException(ProductNotFoundException e) {
        logger.warn(e.getMessage());
        ResponseBody exResponseBody = new ResponseBody("Product Not Found", HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exResponseBody);
    }

    @ExceptionHandler(ProductOutOfStockException.class)
    public ResponseEntity<ResponseBody> handleProductOutOfStockException(ProductOutOfStockException e) {
        logger.warn(e.getMessage());
        ResponseBody exResponseBody = new ResponseBody(HttpStatus.BAD_REQUEST.toString(), HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponseBody);
    }
}
