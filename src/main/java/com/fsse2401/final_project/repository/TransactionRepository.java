package com.fsse2401.final_project.repository;

import com.fsse2401.final_project.data.transaction.entity.TransactionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TransactionRepository extends CrudRepository<TransactionEntity, Integer> {
    @Query(value = "SELECT * FROM transaction t " +
            "WHERE t.status = 'PREPARE'  " +
            "AND t.buyer_uid = :uid ", nativeQuery = true)
    Optional<TransactionEntity> findPendingTransactionByUid(@Param("uid") Integer buyer_uid);

    Optional<TransactionEntity> findByTidAndUser_FirebaseUid(Integer tid, String firebaseUid);
}
