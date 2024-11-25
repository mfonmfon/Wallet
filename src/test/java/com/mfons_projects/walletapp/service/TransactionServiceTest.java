package com.mfons_projects.walletapp.service;

import com.mfons_projects.walletapp.Dtos.request.RetrieveTransactionRequest;
import com.mfons_projects.walletapp.Dtos.request.TransactionRequest;
import com.mfons_projects.walletapp.Dtos.request.UpdateTransactionRequest;
import com.mfons_projects.walletapp.Dtos.response.TransactionResponse;
import com.mfons_projects.walletapp.domain.enums.StatusResponse;
import com.mfons_projects.walletapp.exception.TransactionNotFoundException;
import com.mfons_projects.walletapp.service.interfaces.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static com.mfons_projects.walletapp.domain.enums.TransactionType.DEPOSIT;
import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TransactionServiceTest {

    @Autowired
    private TransactionService transactionService;

    @Test
    public void tesThatCanCreateTransaction(){
        TransactionRequest transactionRequest = buildTransactionRequest();
        TransactionResponse transactionResponse  = transactionService.createTransaction(transactionRequest);
        assertEquals("SUCCESS", transactionResponse.getStatus());
        assertNotNull(transactionResponse);
    }

    private static TransactionRequest buildTransactionRequest() {
        BigDecimal amount = new BigDecimal("4000");
        String narrative = "Sent 50 million dollars to Mfon Mfon for a work weldon";
        String receiverAccountNumber = "8147995494";
        String transactionType = DEPOSIT.toString();
        TransactionRequest transactionRequest = new TransactionRequest();
        transactionRequest.setAmount(amount);
        transactionRequest.setNarrative(narrative);
        transactionRequest.setSenderAccountNumber(receiverAccountNumber);
        transactionRequest.setSenderAccountNumber(transactionType);
        transactionRequest.setTimestamp(now());
        transactionRequest.setStatus(StatusResponse.SUCCESS);
        return transactionRequest;
    }

    @Test
    public void testThatTransactionsCanBeUpdated() throws TransactionNotFoundException {
        RetrieveTransactionRequest transactionRequest = retrieveTransactionRequest();
        TransactionResponse transactionResponse = transactionService.retrieveTransaction(transactionRequest);
        assertEquals("SUCCESS", transactionResponse.getStatus());
    }

    private static RetrieveTransactionRequest retrieveTransactionRequest() {
        Long transactionId = 200L;
        BigDecimal amount = new BigDecimal("300");
        String narrative = "Updated transaction amount to 300 dollars";
        String receiverAccountNumber = "8147995494";
        String transactionType = DEPOSIT.toString();
        RetrieveTransactionRequest transactionRequest = new RetrieveTransactionRequest();
        transactionRequest.setTransactionId(transactionId);
        transactionRequest.setAmount(amount);
        transactionRequest.setNarrative(narrative);
        transactionRequest.setSenderAccountNumber(receiverAccountNumber);
        transactionRequest.setSenderAccountNumber(transactionType);
        transactionRequest.setTimestamp(now());
        transactionRequest.setStatus(StatusResponse.SUCCESS);
        return transactionRequest;
    }
}
