package com.mfons_projects.walletapp.service.interfaces;

import com.mfons_projects.walletapp.Dtos.request.WalletDepositRequest;
import com.mfons_projects.walletapp.Dtos.response.WalletDepositResponse;
import com.mfons_projects.walletapp.exception.WalletNotFoundException;

public interface WalletService {

    WalletDepositResponse deposit(WalletDepositRequest walletDepositRequest) throws WalletNotFoundException;
}
