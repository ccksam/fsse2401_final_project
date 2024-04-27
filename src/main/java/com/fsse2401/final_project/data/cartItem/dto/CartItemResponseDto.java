package com.fsse2401.final_project.data.cartItem.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.final_project.data.cartItem.domainObject.CartItemResponseData;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
public class CartItemResponseDto {
    @Getter
    private Integer pid;
    @Getter
    private String name;
    private String imageUrl;
    @Getter
    private BigDecimal price;
    private Integer cartQuantity;
    @Getter
    private Integer stock;

    public CartItemResponseDto(CartItemResponseData cartItemResData) {
        this.pid = cartItemResData.getProduct().getPid();
        this.name = cartItemResData.getProduct().getName();
        this.imageUrl = cartItemResData.getProduct().getImageUrl();
        this.price = cartItemResData.getProduct().getPrice();
        this.cartQuantity = cartItemResData.getQuantity();
        this.stock = cartItemResData.getProduct().getStock();
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }

    @JsonProperty("cart_quantity")
    public Integer getCartQuantity() {
        return cartQuantity;
    }
}
