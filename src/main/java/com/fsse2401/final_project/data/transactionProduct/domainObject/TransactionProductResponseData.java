package com.fsse2401.final_project.data.transactionProduct.domainObject;

import com.fsse2401.final_project.data.transactionProduct.entity.TransactionProductEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class TransactionProductResponseData {
    private Integer tpid;
    private Integer quantity;
    private Integer pid;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private Integer stock;

    public TransactionProductResponseData(TransactionProductEntity transactionProduct) {
        this.tpid = transactionProduct.getTpid();
        this.pid = transactionProduct.getPid();
        this.name = transactionProduct.getName();
        this.description = transactionProduct.getDescription();
        this.imageUrl = transactionProduct.getImageUrl();
        this.price = transactionProduct.getPrice();
        this.stock = transactionProduct.getStock();
        this.quantity = transactionProduct.getQuantity();
    }
}
