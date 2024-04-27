package com.fsse2401.final_project.data.product.domainObject;

import com.fsse2401.final_project.data.product.entity.ProductEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
public class ProductResponseData {
    private Integer pid;
    private String name;
    private String description;
    private String imageUrl;
    private BigDecimal price;
    private Integer stock;

    public ProductResponseData(ProductEntity productEntity) {
        this.pid = productEntity.getPid();
        this.name = productEntity.getName();
        this.description = productEntity.getDescription();
        this.imageUrl = productEntity.getImageUrl();
        this.price = productEntity.getPrice();
        this.stock = productEntity.getStock();
    }
}
