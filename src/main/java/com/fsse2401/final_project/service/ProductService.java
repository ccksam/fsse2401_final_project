package com.fsse2401.final_project.service;

import com.fsse2401.final_project.data.product.domainObject.ProductResponseData;
import com.fsse2401.final_project.data.product.domainObject.ProductsResponseData;

import java.util.List;

public interface ProductService {
    List<ProductsResponseData> getAllProducts();

    ProductResponseData getAProduct(Integer pid);
}
