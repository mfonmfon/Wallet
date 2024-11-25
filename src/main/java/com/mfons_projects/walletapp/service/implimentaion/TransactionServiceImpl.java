package com.mfons_projects.walletapp.service.implimentaion;

import com.mfons_projects.walletapp.Dtos.request.RetrieveTransactionRequest;
import com.mfons_projects.walletapp.Dtos.request.TransactionRequest;
import com.mfons_projects.walletapp.Dtos.response.TransactionResponse;
import com.mfons_projects.walletapp.domain.models.Transactions;
import com.mfons_projects.walletapp.domain.repository.TransactionRepository;
import com.mfons_projects.walletapp.exception.TransactionNotFoundException;
import com.mfons_projects.walletapp.service.interfaces.TransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private ModelMapper modelMapper;
    private final TransactionRepository transactionRepository;

    @Override
    public TransactionResponse createTransaction(TransactionRequest transactionRequest) {
        Transactions transactions = modelMapper.map(transactionRequest, Transactions.class);
        transactions = transactionRepository.save(transactions);
        return modelMapper.map(transactions, TransactionResponse.class);
    }

    @Override
    public TransactionResponse getTransactionBy(Long transactionId) throws TransactionNotFoundException {
        return modelMapper.map(transactionRepository.findById(transactionId)
                        .orElseThrow(()-> new TransactionNotFoundException("Transaction not found")),
                TransactionResponse.class);
    }

    @Override
    public TransactionResponse retrieveTransaction(RetrieveTransactionRequest transactionRequest) throws TransactionNotFoundException {
        Transactions transactions = transactionRepository.findById(transactionRequest.getTransactionId())
                .orElseThrow(()-> new TransactionNotFoundException(
                        "Transaction not found  for this id" + transactionRequest.getTransactionId()
                ));
        modelMapper.map(transactionRequest, Transactions.class);
        transactions = transactionRepository.save(transactions);
        return modelMapper.map(transactions, TransactionResponse.class);
    }
}
