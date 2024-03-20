package com.fsse2401.final_project.api;

import com.fsse2401.final_project.data.transaction.dto.TransactionResponseDto;
import com.fsse2401.final_project.service.TransactionService;
import com.fsse2401.final_project.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transaction")
public class TransactionApi {
    private final TransactionService transactionService;

    @Autowired
    public TransactionApi(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping("/prepare")
    public TransactionResponseDto createATransaction(JwtAuthenticationToken jwtToken) {
        return new TransactionResponseDto(
                transactionService.createATransaction(
                        JwtUtil.getFirebaseUserData(jwtToken)
                )
        );
    }
}
