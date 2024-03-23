package com.fsse2401.final_project.utils;

import com.fsse2401.final_project.data.transactionProduct.domainObject.TransactionProductResponseData;
import com.fsse2401.final_project.data.transactionProduct.dto.TransactionProductResponseDto;
import com.fsse2401.final_project.data.transactionProduct.entity.TransactionProductEntity;

import java.util.ArrayList;
import java.util.List;

public class TransactionUtils {
    public static List<TransactionProductResponseDto> toTransactionProductResDtoList(
            List<TransactionProductResponseData> transactionProductResDataList
    ) {
        List<TransactionProductResponseDto> resList = new ArrayList<>();
        for (TransactionProductResponseData transactionProductResData : transactionProductResDataList) {
            resList.add(new TransactionProductResponseDto(transactionProductResData));
        }
        return resList;
    }

    public static List<TransactionProductResponseData> toTransactionProductResDataList(
            List<TransactionProductEntity> transactionProductEntityList
    ) {
        List<TransactionProductResponseData> resList = new ArrayList<>();
        for (TransactionProductEntity transactionProduct : transactionProductEntityList) {
            resList.add(new TransactionProductResponseData(transactionProduct));
        }
        return resList;
    }
}
