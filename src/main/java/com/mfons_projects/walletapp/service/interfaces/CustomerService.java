package com.mfons_projects.walletapp.service.interfaces;

import com.mfons_projects.walletapp.Dtos.request.DepositRequest;
import com.mfons_projects.walletapp.Dtos.request.RegistrationRequest;
import com.mfons_projects.walletapp.Dtos.response.DepositResponse;
import com.mfons_projects.walletapp.Dtos.response.RegistrationResponse;
import com.mfons_projects.walletapp.exception.CustomerAlreadyExistException;
import com.mfons_projects.walletapp.exception.UserNotFoundException;
import com.mfons_projects.walletapp.exception.WalletNotFoundException;

public interface CustomerService {
    // Method to register a new customer
    RegistrationResponse register(RegistrationRequest customerRequest) throws CustomerAlreadyExistException;

    DepositResponse deposit(DepositRequest depositRequest) throws UserNotFoundException, WalletNotFoundException;
    // Other methods for customer management (withdraw, transfer, etc.)
}
