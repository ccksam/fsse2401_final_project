package com.fsse2401.final_project.data.product.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fsse2401.final_project.data.product.domainObject.ProductResponseData;
import com.fsse2401.final_project.data.product.entity.ProductEntity;
import com.fsse2401.final_project.data.transactionProduct.domainObject.TransactionProductResponseData;
import com.fsse2401.final_project.utils.BigDecimalSerializer;

import java.math.BigDecimal;

public class ProductResponseDto {
    private Integer pid;
    private String name;
    private String description;
    private String imageUrl;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal price;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
