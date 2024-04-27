package com.fsse2401.final_project.data.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fsse2401.final_project.data.product.domainObject.ProductResponseData;
import com.fsse2401.final_project.data.product.entity.ProductEntity;
import com.fsse2401.final_project.data.transactionProduct.domainObject.TransactionProductResponseData;
import com.fsse2401.final_project.utils.BigDecimalSerializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
public class ProductResponseDto {
    @Getter
    private Integer pid;
    @Getter
    private String name;
    @Getter
    private String description;
    private String imageUrl;
    @Getter
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal price;
    @Getter
    private Integer stock;

    public ProductResponseDto(ProductResponseData productResData) {
        this.pid = productResData.getPid();
        this.name = productResData.getName();
        this.description = productResData.getDescription();
        this.imageUrl = productResData.getImageUrl();
        this.price = productResData.getPrice();
        this.stock = productResData.getStock();
    }

    public ProductResponseDto(TransactionProductResponseData transactionProductResData) {
        this.pid = transactionProductResData.getPid();
        this.name = transactionProductResData.getName();
        this.description = transactionProductResData.getDescription();
        this.imageUrl = transactionProductResData.getImageUrl();
        this.price = transactionProductResData.getPrice();
        this.stock = transactionProductResData.getStock();
    }

    @JsonProperty("image_url")
    public String getImageUrl() {
        return imageUrl;
    }
}
