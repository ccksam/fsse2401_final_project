package com.fsse2401.final_project.data.transactionProduct.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fsse2401.final_project.data.product.dto.ProductResponseDto;
import com.fsse2401.final_project.data.transactionProduct.domainObject.TransactionProductResponseData;
import com.fsse2401.final_project.utils.BigDecimalSerializer;

import java.math.BigDecimal;

public class TransactionProductResponseDto {
    private Integer tpid;
    private Integer quantity;
    private ProductResponseDto product;
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal subtotal = BigDecimal.ZERO;

    public TransactionProductResponseDto(TransactionProductResponseData transactionProductResData) {
        this.tpid = transactionProductResData.getTpid();
        this.quantity = transactionProductResData.getQuantity();
        this.product = new ProductResponseDto(transactionProductResData);
        setSubtotal();
    }

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(BigDecimal subtotal) {
        this.subtotal = subtotal;
    }

    public void setSubtotal() {
        this.subtotal = this.product.getPrice()
                .multiply(BigDecimal.valueOf(this.quantity));
    }

    public ProductResponseDto getProduct() {
        return product;
    }

    public void setProduct(ProductResponseDto product) {
        this.product = product;
    }
}
