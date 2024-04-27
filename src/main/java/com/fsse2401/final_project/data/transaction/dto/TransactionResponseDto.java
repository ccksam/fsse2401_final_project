package com.fsse2401.final_project.data.transaction.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fsse2401.final_project.data.transaction.TransactionStatus;
import com.fsse2401.final_project.data.transaction.domainObject.TransactionResponseData;
import com.fsse2401.final_project.data.transactionProduct.domainObject.TransactionProductResponseData;
import com.fsse2401.final_project.data.transactionProduct.dto.TransactionProductResponseDto;
import com.fsse2401.final_project.utils.BigDecimalSerializer;
import com.fsse2401.final_project.utils.TransactionUtils;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@JsonPropertyOrder({"tid", "buyer_uid", "datetime", "status", "total", "items"})
public class TransactionResponseDto {
    @Setter
    private Integer tid;
    @Setter
    @JsonProperty("buyer_uid")
    private Integer buyerUid;
    @Setter
    @JsonFormat(pattern = "yyyyMMdd'T'HH:mm:SS")
    private LocalDateTime datetime;
    @Setter
    private TransactionStatus status;
    @Setter
    @JsonSerialize(using = BigDecimalSerializer.class)
    private BigDecimal total;
    private List<TransactionProductResponseDto> items;

    public TransactionResponseDto(TransactionResponseData transactionResponseData) {
        this.tid = transactionResponseData.getTid();
        this.buyerUid = transactionResponseData.getUser().getUid();
        this.datetime = transactionResponseData.getDatetime();
        this.status = transactionResponseData.getStatus();
        this.total = transactionResponseData.getTotal();
        setItems(transactionResponseData.getItems());
    }

    public void setItems(List<TransactionProductResponseData> items) {
        this.items = TransactionUtils.toTransactionProductResDtoList(items);
    }
}
