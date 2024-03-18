package com.fsse2401.final_project.data.cartItem.domainObject;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.product.entity.ProductEntity;
import com.fsse2401.final_project.data.user.entity.UserEntity;

public class CartItemResponseData {
    private Integer cid;
    private Integer quantity;
    private UserEntity user;
    private ProductEntity product;

    public CartItemResponseData(CartItemEntity cartItem) {
        this.cid = cartItem.getCid();
        this.quantity = cartItem.getQuantity();
        this.user = cartItem.getUser();
        this.product = cartItem.getProduct();
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
