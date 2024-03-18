package com.fsse2401.final_project.exceptions.product;

public class ProductOutOfStockException extends RuntimeException {
    public ProductOutOfStockException(Integer pid) {
        super(String.format("Invalid quantity, product %d out of stock", pid));
    }
}
