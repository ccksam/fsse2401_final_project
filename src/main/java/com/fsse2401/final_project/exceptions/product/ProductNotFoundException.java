package com.fsse2401.final_project.exceptions.product;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String exceptionMsg) {
        super(String.format("Product %s not found", exceptionMsg));
    }
}
