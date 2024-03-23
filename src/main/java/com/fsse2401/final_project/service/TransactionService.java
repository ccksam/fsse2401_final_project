package com.fsse2401.final_project.service;

import com.fsse2401.final_project.data.transaction.TransactionStatus;
import com.fsse2401.final_project.data.transaction.domainObject.TransactionResponseData;
import com.fsse2401.final_project.data.transaction.entity.TransactionEntity;
import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;

public interface TransactionService {

    TransactionResponseData createATransaction(FirebaseUserData firebaseUserData);

    TransactionResponseData getTransactionById(FirebaseUserData firebaseUserData, Integer tid);

    void processTransaction(FirebaseUserData firebaseUserData, Integer tid);

    TransactionResponseData finishTransaction(FirebaseUserData firebaseUserData, Integer tid);

    TransactionEntity getEntityByTidAndFirebaseUid(Integer tid, String firebaseUid);
}
