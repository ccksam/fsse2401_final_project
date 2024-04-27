package com.fsse2401.final_project.data.transaction.domainObject;

import com.fsse2401.final_project.data.transaction.TransactionStatus;
import com.fsse2401.final_project.data.transaction.entity.TransactionEntity;
import com.fsse2401.final_project.data.transactionProduct.domainObject.TransactionProductResponseData;
import com.fsse2401.final_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.final_project.data.user.domainObject.UserResponseData;
import com.fsse2401.final_project.utils.TransactionUtils;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class TransactionResponseData {
    @Setter
    private Integer tid;
    @Setter
    private UserResponseData user;
    @Setter
    private LocalDateTime datetime;
    @Setter
    private TransactionStatus status;
    @Setter
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

    public void setItems(List<TransactionProductEntity> items) {
        this.items= TransactionUtils.toTransactionProductResDataList(items);
    }
}
