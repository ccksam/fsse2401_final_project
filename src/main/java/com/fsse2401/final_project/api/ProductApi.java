package com.fsse2401.final_project.api;

import com.fsse2401.final_project.data.product.dto.ProductResponseDto;
import com.fsse2401.final_project.data.product.dto.ProductsResponseDto;
import com.fsse2401.final_project.service.ProductService;
import com.fsse2401.final_project.utils.ProductDataUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/public/product")
public class ProductApi {
    private final ProductService productService;

    @Autowired
    public ProductApi(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<ProductsResponseDto> getAllProducts() {
        return ProductDataUtils.toProductDtoList(productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ProductResponseDto getAProduct(@PathVariable("id") Integer pid) throws TypeMismatchException {
        return new ProductResponseDto(productService.getAProduct(pid));
    }
}
