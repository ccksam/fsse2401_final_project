package com.fsse2401.final_project.service;

import com.fsse2401.final_project.data.transaction.domainObject.TransactionResponseData;
import com.fsse2401.final_project.data.user.domainObject.FirebaseUserData;

public interface TransactionService {

    TransactionResponseData createATransaction(FirebaseUserData firebaseUserData);
}
