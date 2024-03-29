package com.fsse2401.final_project.service.impl;

import com.fsse2401.final_project.data.product.domainObject.ProductResponseData;
import com.fsse2401.final_project.data.product.domainObject.ProductsResponseData;
import com.fsse2401.final_project.data.product.entity.ProductEntity;
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
        return new ProductResponseData(productRepository.findById(pid)
                .orElseThrow(() -> new ProductNotFoundException(pid)));
    }

    @Override
    public ProductEntity getProductById(Integer pid) {
        return productRepository.findById(pid)
                .orElseThrow(() -> new ProductNotFoundException(pid));
    }

    @Override
    public ProductEntity saveEntity(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    @Override
    public List<ProductEntity> saveAllProducts(List<ProductEntity> productEntities) {
        return (List<ProductEntity>) productRepository.saveAll(productEntities);
    }

    @Override
    public boolean outOfStock(ProductEntity product, Integer quantity) {
        return product.getStock() < quantity;
    }
}
