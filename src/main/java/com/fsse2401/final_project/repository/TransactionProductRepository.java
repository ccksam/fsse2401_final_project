package com.fsse2401.final_project.repository;

import com.fsse2401.final_project.data.transactionProduct.entity.TransactionProductEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionProductRepository extends CrudRepository<TransactionProductEntity, Integer> {
}
