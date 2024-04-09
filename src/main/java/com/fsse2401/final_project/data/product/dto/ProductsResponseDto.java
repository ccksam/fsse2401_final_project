package com.fsse2401.final_project.data.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fsse2401.final_project.data.product.domainObject.ProductsResponseData;
import com.fsse2401.final_project.utils.BigDecimalSerializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

public class ProductsResponseDto {
    @Setter
    @Getter
    private Integer pid;
    @Setter
    @Getter
    private String name;
    @Setter
    private String imageUrl;
    @Setter
    @Getter
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal price;
    private Boolean hasStock;

    public ProductsResponseDto(ProductsResponseData productsResData) {
        this.pid = productsResData.getPid();
        this.name = productsResData.getName();
        this.imageUrl = productsResData.getImageUrl();
        this.price = productsResData.getPrice();
        this.setHasStock(productsResData.getStock());
    }

    @JsonProperty("image_url")
    public String getimageUrl() {
        return imageUrl;
    }

    @JsonProperty("has_stock")
    public Boolean getHasStock() {
        return hasStock;
    }

    public void setHasStock(Integer stock) {
        this.hasStock = stock > 0;
    }
}
