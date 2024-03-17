package com.fsse2401.final_project.api;

import com.fsse2401.final_project.data.cartItem.dto.CartItemResponseDto;
import com.fsse2401.final_project.data.cartItem.dto.CartStatusResponseDto;
import com.fsse2401.final_project.service.CartItemService;
import com.fsse2401.final_project.utils.CartItemDataUtils;
import com.fsse2401.final_project.utils.JwtUtil;
import org.springframework.beans.TypeMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartItemApi {
    private final CartItemService cartItemService;

    @Autowired
    public CartItemApi(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping
    public List<CartItemResponseDto> getCartItems(JwtAuthenticationToken jwtToken) {
        return CartItemDataUtils.toCartItemDto(cartItemService.getCartItems(
                JwtUtil.getFirebaseUserData(jwtToken)
        ));
    }

    @PutMapping("/{pid}/{quantity}")
    public CartStatusResponseDto putCartItem(
            JwtAuthenticationToken jwtToken,
            @PathVariable Integer pid,
            @PathVariable Integer quantity) throws TypeMismatchException {
        return new CartStatusResponseDto(
                cartItemService.putCartItem(
                        JwtUtil.getFirebaseUserData(jwtToken), pid, quantity
                )
        );
    }

    @PatchMapping("/{pid}/{quantity}")
    public CartItemResponseDto updateCartItemQty(
            @PathVariable Integer pid,
            @PathVariable Integer quantity,
            JwtAuthenticationToken jwtToken) throws TypeMismatchException {
        return new CartItemResponseDto(
                cartItemService.updateCartItemQty(
                        JwtUtil.getFirebaseUserData(jwtToken), pid, quantity
                ));
    }

    @DeleteMapping("/{pid}")
    public CartStatusResponseDto removeCartItem(JwtAuthenticationToken jwtToken, @PathVariable Integer pid) {
        return new CartStatusResponseDto(
                cartItemService.removeCartItem(JwtUtil.getFirebaseUserData(jwtToken), pid)
        );
    }
}
