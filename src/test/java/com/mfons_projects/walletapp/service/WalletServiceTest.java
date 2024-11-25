package com.mfons_projects.walletapp.service;

import com.mfons_projects.walletapp.Dtos.request.WalletDepositRequest;
import com.mfons_projects.walletapp.Dtos.response.WalletDepositResponse;
import com.mfons_projects.walletapp.exception.WalletNotFoundException;
import com.mfons_projects.walletapp.service.interfaces.WalletService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class WalletServiceTest {

    @Autowired
    private WalletService walletService;

    @Test
    @Sql("/db/database.sql")
    public void testThatCanDepositIntoWallet() throws WalletNotFoundException {
        Long walletId = 100L;
        BigDecimal depositAmount = new BigDecimal("5000");
        WalletDepositRequest walletDepositRequest = new WalletDepositRequest();
        walletDepositRequest.setWalletId(walletId);
        walletDepositRequest.setAmount(depositAmount);
        WalletDepositResponse walletDepositResponse = walletService.deposit(walletDepositRequest);
        assertEquals("SUCCESS", walletDepositResponse.getStatus());
    }
}