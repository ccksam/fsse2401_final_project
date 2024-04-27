package com.fsse2401.final_project.data.cartItem.domainObject;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.product.domainObject.ProductResponseData;
import com.fsse2401.final_project.data.product.entity.ProductEntity;
import com.fsse2401.final_project.data.user.domainObject.UserResponseData;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CartItemResponseData {
    private Integer cid;
    private Integer quantity;
    private UserResponseData user;
    private ProductResponseData product;

    public CartItemResponseData(CartItemEntity cartItem) {
        this.cid = cartItem.getCid();
        this.quantity = cartItem.getQuantity();
        this.user = new UserResponseData(cartItem.getUser());
        this.product = new ProductResponseData(cartItem.getProduct());
    }
}
