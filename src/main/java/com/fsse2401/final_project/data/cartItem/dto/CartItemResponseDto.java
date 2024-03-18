package com.fsse2401.final_project.data.cartItem.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.final_project.data.cartItem.domainObject.CartItemResponseData;

import java.math.BigDecimal;

public class CartItemResponseDto {
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Integer cartQuantity;
    private Integer stock;

    public CartItemResponseDto(CartItemResponseData cartItemResData) {
        this.pid = cartItemResData.getProduct().getPid();
        this.name = cartItemResData.getProduct().getName();
        this.imageUrl = cartItemResData.getProduct().getimageUrl();
        this.price = cartItemResData.getProduct().getPrice();
        this.cartQuantity = cartItemResData.getQuantity();
        this.stock = cartItemResData.getProduct().getStock();
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

    @JsonProperty("image_url")
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

    @JsonProperty("cart_quantity")
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
