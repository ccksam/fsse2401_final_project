package com.fsse2401.final_project.utils;

import com.fsse2401.final_project.data.cartItem.domainObject.CartItemResponseData;
import com.fsse2401.final_project.data.cartItem.dto.CartItemResponseDto;
import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;

import java.util.ArrayList;
import java.util.List;

public class CartItemDataUtils {
    public static List<CartItemResponseData> toCartItemData(List<CartItemEntity> cartItemEntities) {
        List<CartItemResponseData> cartItemResponseDataList = new ArrayList<>();
        for (CartItemEntity cartItem : cartItemEntities) {
            cartItemResponseDataList.add(new CartItemResponseData(cartItem));
        }
        return cartItemResponseDataList;
    }

    public static List<CartItemResponseDto> toCartItemDto(List<CartItemResponseData> cartItemData) {
        List<CartItemResponseDto> cartItemResponseDtoList = new ArrayList<>();
        for (CartItemResponseData cartItem : cartItemData) {
            cartItemResponseDtoList.add(new CartItemResponseDto(cartItem));
        }
        return cartItemResponseDtoList;
    }
}
