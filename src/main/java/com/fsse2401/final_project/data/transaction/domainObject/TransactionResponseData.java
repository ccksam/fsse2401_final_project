package com.fsse2401.final_project.data.transaction.domainObject;

import com.fsse2401.final_project.data.transaction.TransactionStatus;
import com.fsse2401.final_project.data.transaction.entity.TransactionEntity;
import com.fsse2401.final_project.data.transactionProduct.domainObject.TransactionProductResponseData;
import com.fsse2401.final_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.final_project.data.user.domainObject.UserResponseData;
import com.fsse2401.final_project.utils.TransactionUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TransactionResponseData {
    private Integer tid;
    private UserResponseData user;
    private LocalDateTime datetime;
    private TransactionStatus status;
    private BigDecimal total;
    private List<TransactionProductResponseData> items = new ArrayList<>();

    public TransactionResponseData(TransactionEntity transaction) {
        this.tid = transaction.getTid();
        this.user = new UserResponseData(transaction.getUser());
        this.datetime = transaction.getDatetime();
        this.status = transaction.getStatus();
        this.total = transaction.getTotal();
        this.setItems(transaction.getItems());
    }

    public UserResponseData getUser() {
        return user;
    }

    public void setUser(UserResponseData user) {
        this.user = user;
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


    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }


    public List<TransactionProductResponseData> getItems() {
        return items;
    }

    public void setItems(List<TransactionProductEntity> items) {
        this.items= TransactionUtils.toTransactionProductResDataList(items);
    }
}
