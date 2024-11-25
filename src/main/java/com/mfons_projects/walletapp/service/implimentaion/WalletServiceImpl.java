package com.mfons_projects.walletapp.service.implimentaion;

import com.mfons_projects.walletapp.Dtos.request.WalletDepositRequest;
import com.mfons_projects.walletapp.Dtos.response.WalletDepositResponse;
import com.mfons_projects.walletapp.domain.models.Wallet;
import com.mfons_projects.walletapp.domain.repository.WalletRepository;
import com.mfons_projects.walletapp.exception.WalletNotFoundException;
import com.mfons_projects.walletapp.service.interfaces.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private ModelMapper modelMapper;
    @Override
    public WalletDepositResponse deposit(WalletDepositRequest walletDepositRequest) throws WalletNotFoundException {
        Wallet wallet = walletRepository.findById(walletDepositRequest.getWalletId())
                .orElseThrow(()-> new WalletNotFoundException(
                       String.format(
                               "Wallet not found for this id " + walletDepositRequest.getWalletId()
                       )));
        wallet.setBalance(wallet.getBalance().add(walletDepositRequest.getAmount()));
        wallet = walletRepository.save(wallet);
        WalletDepositResponse walletDepositResponse = new WalletDepositResponse();
        walletDepositResponse.setStatus("SUCCESS");
        walletDepositResponse.setAmount(walletDepositRequest.getAmount().toString());
        return walletDepositResponse;
    }
}
