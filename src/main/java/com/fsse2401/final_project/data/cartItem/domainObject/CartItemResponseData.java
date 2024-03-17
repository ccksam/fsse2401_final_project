package com.fsse2401.final_project.data.cartItem.domainObject;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;

import java.math.BigDecimal;

public class CartItemResponseData {
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer cartQuantity;
    private Integer stock;

    public CartItemResponseData(CartItemEntity cartItem) {
        this.pid = cartItem.getProduct().getPid();
        this.name = cartItem.getProduct().getName();
        this.imageUrl = cartItem.getProduct().getimageUrl();
        this.price = cartItem.getProduct().getPrice();
        this.cartQuantity = cartItem.getQuantity();
        this.stock = cartItem.getProduct().getStock();
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getCartQuantity() {
        return cartQuantity;
    }

    public void setCartQuantity(Integer cartQuantity) {
        this.cartQuantity = cartQuantity;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
