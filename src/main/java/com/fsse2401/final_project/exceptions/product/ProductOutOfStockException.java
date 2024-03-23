package com.fsse2401.final_project.exceptions.product;

public class ProductOutOfStockException extends RuntimeException {
    public ProductOutOfStockException(Integer pid) {
        super(String.format("Invalid quantity, product %d out of stock", pid));
    }

    public ProductOutOfStockException(Integer pid, Integer tid) {
        super(String.format("processTransaction(tid = %d) : product %d out of stock", tid, pid));
    }
}
