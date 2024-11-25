package com.mfons_projects.walletapp.service.implimentaion;

import com.mfons_projects.walletapp.Dtos.request.DepositRequest;
import com.mfons_projects.walletapp.Dtos.request.RegistrationRequest;
import com.mfons_projects.walletapp.Dtos.request.WalletDepositRequest;
import com.mfons_projects.walletapp.Dtos.response.DepositResponse;
import com.mfons_projects.walletapp.Dtos.response.RegistrationResponse;
import com.mfons_projects.walletapp.Dtos.response.WalletDepositResponse;
import com.mfons_projects.walletapp.domain.enums.StatusResponse;
import com.mfons_projects.walletapp.domain.models.Customer;
import com.mfons_projects.walletapp.domain.models.Transactions;
import com.mfons_projects.walletapp.domain.models.Wallet;
import com.mfons_projects.walletapp.domain.repository.CustomerRepository;
import com.mfons_projects.walletapp.exception.CustomerAlreadyExistException;
import com.mfons_projects.walletapp.exception.UserNotFoundException;
import com.mfons_projects.walletapp.exception.WalletNotFoundException;
import com.mfons_projects.walletapp.service.interfaces.CustomerService;
import com.mfons_projects.walletapp.service.interfaces.WalletService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;
    private final WalletService walletService;
    @Autowired
    private  ModelMapper mapper;
    @Override
    public RegistrationResponse register(RegistrationRequest customerRequest) throws CustomerAlreadyExistException {
//        validateCustomerEmail(customerRequest.getEmail());
        Customer customer  = mapper.map(customerRequest, Customer.class);
        customer = customerRepository.save(customer);
        RegistrationResponse registrationResponse = mapper.map(customer, RegistrationResponse.class);
        registrationResponse.setStatus("SUCCESS");
        return registrationResponse;
    }

    @Override
    public DepositResponse deposit(DepositRequest depositRequest) throws UserNotFoundException, WalletNotFoundException {
        Customer customer = customerRepository.findById(depositRequest.getCustomerId()).
                orElseThrow(()-> new UserNotFoundException(
                        String.format("User not found for this id " + depositRequest.getCustomerId())
                ));
        Wallet customerWallet = customer.getWallet();
        customerWallet.setBalance(customerWallet.getBalance().add(depositRequest.getAmount()));
        WalletDepositRequest walletDepositRequest = new WalletDepositRequest();
        walletDepositRequest.setAmount(depositRequest.getAmount());
        walletDepositRequest.setWalletId(walletDepositRequest.getWalletId());
        WalletDepositResponse walletDepositResponse = walletService.deposit(walletDepositRequest);
        walletDepositResponse.setStatus(StatusResponse.SUCCESS.toString());
        Transactions transactions = new Transactions();
        return null;

    }

    private void validateCustomerEmail(String email) throws CustomerAlreadyExistException {
        boolean isCustomerEmailExist = customerRepository.findByEmail(email);
        if(isCustomerEmailExist)throw new CustomerAlreadyExistException("Customer already exists");
    }
}
