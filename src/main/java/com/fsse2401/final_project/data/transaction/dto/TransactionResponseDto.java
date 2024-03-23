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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@JsonPropertyOrder({"tid", "buyer_uid", "datetime", "status", "total", "items"})
public class TransactionResponseDto {
    private Integer tid;
    @JsonProperty("buyer_uid")
    private Integer buyerUid;
    @JsonFormat(pattern = "yyyyMMdd'T'HH:mm:SS")
    private LocalDateTime datetime;
    private TransactionStatus status;
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

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public Integer getBuyerUid() {
        return buyerUid;
    }

    public void setBuyerUid(Integer buyerUid) {
        this.buyerUid = buyerUid;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public TransactionStatus getStatus() {
        return status;
    }

    public void setStatus(TransactionStatus status) {
        this.status = status;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<TransactionProductResponseDto> getItems() {
        return items;
    }

    public void setItems(List<TransactionProductResponseData> items) {
        this.items = TransactionUtils.toTransactionProductResDtoList(items);
    }
}
