package com.fsse2401.final_project.data.transactionProduct.entity;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.transaction.entity.TransactionEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;

//get the snapshot of product info in the cartItem.

@Entity
@Table(name = "transaction_product")
public class TransactionProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tpid;

    private Integer pid;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private String name;
    private String description;
    private String imageUrl;
    @Column(nullable = false, precision = 30, scale = 4)
    private BigDecimal price;
    @Column(nullable = false)
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "tid", nullable = false)
    private TransactionEntity transaction;

    public TransactionProductEntity(TransactionEntity transaction, CartItemEntity cartItem) {
        this.pid = cartItem.getProduct().getPid();
        this.name = cartItem.getProduct().getName();
        this.description = cartItem.getProduct().getDescription();
        this.imageUrl = cartItem.getProduct().getimageUrl();
        this.price = cartItem.getProduct().getPrice();
        this.stock = cartItem.getProduct().getStock();
        this.quantity = cartItem.getQuantity();
        this.transaction = transaction;
    }

    public TransactionProductEntity() {
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public TransactionEntity getTransaction() {
        return transaction;
    }

    public void setTransaction(TransactionEntity transaction) {
        this.transaction = transaction;
    }
}
