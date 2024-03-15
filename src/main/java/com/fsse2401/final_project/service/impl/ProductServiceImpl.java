package com.fsse2401.final_project.service.impl;

import com.fsse2401.final_project.data.product.domainObject.ProductResponseData;
import com.fsse2401.final_project.data.product.domainObject.ProductsResponseData;
import com.fsse2401.final_project.exceptions.product.ProductNotFoundException;
import com.fsse2401.final_project.repository.ProductRepository;
import com.fsse2401.final_project.service.ProductService;
import com.fsse2401.final_project.utils.ProductDataUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductsResponseData> getAllProducts() {
        return ProductDataUtils.toProductDataList(productRepository.findAllAsList());
    }

    @Override
    public ProductResponseData getAProduct(Integer pid) {
        return new ProductResponseData(
                productRepository.findById(pid)
                        .orElseThrow(() -> new ProductNotFoundException(pid + "")));
    }
}
