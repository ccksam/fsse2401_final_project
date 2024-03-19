package com.fsse2401.final_project.data.cartItem.domainObject;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.product.domainObject.ProductResponseData;
import com.fsse2401.final_project.data.product.entity.ProductEntity;
import com.fsse2401.final_project.data.user.domainObject.UserResponseData;
import com.fsse2401.final_project.data.user.entity.UserEntity;

public class CartItemResponseData {
    private Integer cid;
    private Integer quantity;
    private UserResponseData user;
    private ProductResponseData product;

    public CartItemResponseData(CartItemEntity cartItem) {
        this.cid = cartItem.getCid();
        this.quantity = cartItem.getQuantity();
        this.user = new UserResponseData(cartItem.getUser());
        this.product = new ProductResponseData(cartItem.getProduct());
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

    public UserResponseData getUser() {
        return user;
    }

    public void setUser(UserResponseData user) {
        this.user = user;
    }

    public ProductResponseData getProduct() {
        return product;
    }

    public void setProduct(ProductResponseData product) {
        this.product = product;
    }
}
