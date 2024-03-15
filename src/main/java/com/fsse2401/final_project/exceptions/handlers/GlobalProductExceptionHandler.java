package com.fsse2401.final_project.exceptions.handlers;

import com.fsse2401.final_project.exceptions.ResponseBody;
import com.fsse2401.final_project.exceptions.product.ProductNotFoundException;
import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalProductExceptionHandler {
    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<ResponseBody> handleTypeMismatchException(TypeMismatchException e) {
        ResponseBody exResponseBody = new ResponseBody("Invalid Product ID", HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exResponseBody);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ResponseBody> handleProductNotFoundException(ProductNotFoundException e) {
        ResponseBody exResponseBody = new ResponseBody(e.getMessage(), HttpStatus.NOT_FOUND.value());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exResponseBody);
    }
}
