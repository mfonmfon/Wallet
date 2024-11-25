package com.mfons_projects.walletapp.service.interfaces;

import com.mfons_projects.walletapp.Dtos.request.RetrieveTransactionRequest;
import com.mfons_projects.walletapp.Dtos.request.TransactionRequest;
import com.mfons_projects.walletapp.Dtos.response.TransactionResponse;
import com.mfons_projects.walletapp.exception.TransactionNotFoundException;

public interface TransactionService {

    TransactionResponse createTransaction(TransactionRequest transactionRequest);
    TransactionResponse getTransactionBy(Long transactionId) throws TransactionNotFoundException;
    TransactionResponse retrieveTransaction(RetrieveTransactionRequest transactionRequest) throws TransactionNotFoundException;

}
