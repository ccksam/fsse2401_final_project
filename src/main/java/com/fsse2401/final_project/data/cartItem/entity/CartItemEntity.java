package com.fsse2401.final_project.data.cartItem.entity;

import com.fsse2401.final_project.data.product.entity.ProductEntity;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import jakarta.persistence.*;

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

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }
}
