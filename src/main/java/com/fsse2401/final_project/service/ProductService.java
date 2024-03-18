package com.fsse2401.final_project.service;

import com.fsse2401.final_project.data.product.domainObject.ProductResponseData;
import com.fsse2401.final_project.data.product.domainObject.ProductsResponseData;
import com.fsse2401.final_project.data.product.entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductsResponseData> getAllProducts();

    ProductResponseData getAProduct(Integer pid);

    ProductEntity getProductById(Integer pid);

    ProductEntity saveProduct(ProductEntity productEntity);

    boolean outOfStock(ProductEntity product, Integer quantity);
}
