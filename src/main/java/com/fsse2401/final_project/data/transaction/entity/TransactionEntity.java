package com.fsse2401.final_project.data.transaction.entity;

import com.fsse2401.final_project.data.transaction.TransactionStatus;
import com.fsse2401.final_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.final_project.data.user.entity.UserEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "transaction")
public class TransactionEntity {
    @Id
    @Setter
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @Setter
    @ManyToOne
    @JoinColumn(name = "buyer_uid", nullable = false)
    private UserEntity user;

    @Setter
    private LocalDateTime datetime;

    @Setter
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    // not necessary store to db
    @Setter
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
