package com.fsse2401.final_project.data.transactionProduct.entity;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.transaction.entity.TransactionEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
//get the snapshot of product info in the cartItem.

@Entity
@Setter @Getter
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

    @ManyToOne (cascade = CascadeType.ALL)
    @JoinColumn(name = "tid", nullable = false)
    private TransactionEntity transaction;

    // get a snapshot of cartItem (primitive value), the moment transactionProduct being new() NOT EQUAL current product
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
}
