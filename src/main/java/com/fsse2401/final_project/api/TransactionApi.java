package com.fsse2401.final_project.api;

import com.fsse2401.final_project.data.transaction.dto.TransactionResponseDto;
import com.fsse2401.final_project.data.transaction.dto.TransactionSuccessResponseDto;
import com.fsse2401.final_project.service.TransactionService;
import com.fsse2401.final_project.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{tid}")
    public TransactionResponseDto getTransactionById(JwtAuthenticationToken jwtToken, @PathVariable Integer tid) {
        return new TransactionResponseDto(
                transactionService.getTransactionById(JwtUtil.getFirebaseUserData(jwtToken), tid)
        );
    }

    @PatchMapping("/{tid}/pay")
    public TransactionSuccessResponseDto processTransaction(JwtAuthenticationToken jwtToken, @PathVariable Integer tid) {
        transactionService.processTransaction(JwtUtil.getFirebaseUserData(jwtToken), tid);
        return new TransactionSuccessResponseDto();
    }

    @PatchMapping("/{tid}/finish")
    public TransactionResponseDto finishTransaction(JwtAuthenticationToken jwtToken, @PathVariable Integer tid) {
        return new TransactionResponseDto(
                transactionService.finishTransaction(
                        JwtUtil.getFirebaseUserData(jwtToken), tid
                )
        );
    }
}
