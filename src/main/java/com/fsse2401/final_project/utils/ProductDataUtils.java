package com.fsse2401.final_project.utils;

import com.fsse2401.final_project.data.product.domainObject.ProductsResponseData;
import com.fsse2401.final_project.data.product.dto.ProductsResponseDto;
import com.fsse2401.final_project.data.product.entity.ProductEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductDataUtils {
    public static List<ProductsResponseDto> toProductDtoList(List<ProductsResponseData> productResDataList) {
        List<ProductsResponseDto> resList = new ArrayList<>();
        for (ProductsResponseData productResData : productResDataList) {
            resList.add(new ProductsResponseDto(productResData));
        }
        return resList;
    }

    public static List<ProductsResponseData> toProductDataList(List<ProductEntity> productEntityList) {
        List<ProductsResponseData> resList = new ArrayList<>();
        for (ProductEntity productEntity : productEntityList) {
            resList.add(new ProductsResponseData(productEntity));
        }
        return resList;
    }
}
