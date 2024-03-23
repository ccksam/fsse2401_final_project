package com.fsse2401.final_project.data.transaction.entity;

import com.fsse2401.final_project.data.transaction.TransactionStatus;
import com.fsse2401.final_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @ManyToOne
    @JoinColumn(name = "buyer_uid", nullable = false)
    private UserEntity user;

    private LocalDateTime datetime;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    // not necessary store to db
    @Column(nullable = false)
    private BigDecimal total = BigDecimal.ZERO;

    // Optional
    @OneToMany(mappedBy = "transaction")
    private List<TransactionProductEntity> items = new ArrayList<>();

    public TransactionEntity(UserEntity user) {
        this.user = user;
        this.datetime = LocalDateTime.now();
        this.status = TransactionStatus.PREPARE;
    }

    public TransactionEntity() {
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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

    public List<TransactionProductEntity> getItems() {
        return items;
    }

    public void setItems(List<TransactionProductEntity> items) {
        this.items = items;
        //   when setting items, (manually sync non-owning side)
        //      calculate total from each transactionProduct
        for (TransactionProductEntity transactionProduct : items) {
            this.total = this.total.add(
                    transactionProduct.getPrice()
                            .multiply(BigDecimal.valueOf(transactionProduct.getQuantity()))
            );
        }
    }
}
