package com.fsse2401.final_project.data.transaction.dto;

import lombok.Getter;

@Getter
public class TransactionSuccessResponseDto {
    private String result = "SUCCESS";


    private void setResult() {
        this.result = "SUCCESS";
    }
}
