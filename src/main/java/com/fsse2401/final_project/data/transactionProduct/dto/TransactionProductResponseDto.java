package com.fsse2401.final_project.data.transactionProduct.dto;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fsse2401.final_project.data.product.dto.ProductResponseDto;
import com.fsse2401.final_project.data.transactionProduct.domainObject.TransactionProductResponseData;
import com.fsse2401.final_project.utils.BigDecimalSerializer;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Setter @Getter
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

    public void setSubtotal() {
        this.subtotal = this.product.getPrice()
                .multiply(BigDecimal.valueOf(this.quantity));
    }
}
