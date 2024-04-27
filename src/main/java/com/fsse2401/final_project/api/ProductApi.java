package com.fsse2401.final_project.api;

import com.fsse2401.final_project.config.EnvConfig;
import com.fsse2401.final_project.data.product.dto.ProductResponseDto;
import com.fsse2401.final_project.data.product.dto.ProductsResponseDto;
import com.fsse2401.final_project.service.ProductService;
import com.fsse2401.final_project.utils.ProductDataUtils;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin({EnvConfig.DEV_BASE_URL, EnvConfig.PROD_BASE_URL,EnvConfig.PROD_S3_BASE_URL})
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
