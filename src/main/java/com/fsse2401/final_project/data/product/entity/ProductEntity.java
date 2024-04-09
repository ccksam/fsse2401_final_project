package com.fsse2401.final_project.data.product.entity;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "product")
public class ProductEntity {
    @Setter @Getter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer pid;
    @Setter @Getter
    @Column(nullable = false)
    private String name;
    @Setter @Getter
    private String description;
    @Setter @Getter
    private String imageUrl;
    @Setter @Getter
    @Column(nullable = false, precision = 30, scale = 4)
    private BigDecimal price;
    @Setter @Getter
    @Column(nullable = false)
    private Integer stock;

    // non-use attribute, just for cascade operation on CartItemEntity
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<CartItemEntity> customers;

    public ProductEntity() {
    }

    public ProductEntity(Integer pid, String name, String description, String imageUrl, BigDecimal price, Integer stock) {
        this.pid = pid;
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
        this.price = price;
        this.stock = stock;
    }
}
