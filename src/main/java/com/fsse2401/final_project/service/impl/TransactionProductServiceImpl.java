package com.fsse2401.final_project.service.impl;

import com.fsse2401.final_project.data.cartItem.entity.CartItemEntity;
import com.fsse2401.final_project.data.transaction.entity.TransactionEntity;
import com.fsse2401.final_project.data.transactionProduct.entity.TransactionProductEntity;
import com.fsse2401.final_project.repository.TransactionProductRepository;
import com.fsse2401.final_project.service.TransactionProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionProductServiceImpl implements TransactionProductService {
    private final TransactionProductRepository transactionProductRepository;

    @Autowired
    public TransactionProductServiceImpl(TransactionProductRepository transactionProductRepository) {
        this.transactionProductRepository = transactionProductRepository;
    }

    @Override
    public List<TransactionProductEntity> createTransactionProducts(
            TransactionEntity transaction, List<CartItemEntity> cartItems) {
        List<TransactionProductEntity> transactionProductEntities = new ArrayList<>();
        for (CartItemEntity cartItem : cartItems) {
            transactionProductEntities.add(
                    transactionProductRepository.save(new TransactionProductEntity(transaction, cartItem)));
        }
        return transactionProductEntities;
    }
}
