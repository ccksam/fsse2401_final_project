package com.fsse2401.final_project.data.cartItem.entity;

import com.fsse2401.final_project.data.product.entity.ProductEntity;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "cart_item")
public class CartItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "user_uid", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "product_pid", nullable = false)
    private ProductEntity product;

    public CartItemEntity(Integer quantity, UserEntity user, ProductEntity product) {
        this.quantity = quantity;
        this.user = user;
        this.product = product;
    }

    public CartItemEntity() {
    }
}
