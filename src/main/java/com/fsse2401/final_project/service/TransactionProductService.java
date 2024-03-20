package com.fsse2401.final_project.service;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.transaction.entity.TransactionEntity;
import com.fsse2401.final_project.data.transactionProduct.entity.TransactionProductEntity;

import java.util.List;

public interface TransactionProductService {

    List<TransactionProductEntity> createTransactionProducts(
            TransactionEntity transaction, List<CartItemEntity> cartItems);
}
