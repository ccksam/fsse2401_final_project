package com.fsse2401.final_project.data.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fsse2401.final_project.data.product.domainObject.ProductsResponseData;

import java.math.BigDecimal;

public class ProductsResponseDto {
    private Integer pid;
    private String name;
    private String imageUrl;
    private BigDecimal price;
    private Boolean hasStock;

    public ProductsResponseDto(ProductsResponseData productsResData) {
        this.pid = productsResData.getPid();
        this.name = productsResData.getName();
        this.imageUrl = productsResData.getImageUrl();
        this.price = productsResData.getPrice();
        this.setHasStock(productsResData.getStock());
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
    public String getimageUrl() {
        return imageUrl;
    }

    public void setimageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @JsonProperty("has_stock")
    public Boolean getHasStock() {
        return hasStock;
    }

    public void setHasStock(Integer stock) {
        this.hasStock = stock > 0;
    }
}
