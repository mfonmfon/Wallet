package com.mfons_projects.walletapp.service;

import com.mfons_projects.walletapp.Dtos.request.DepositRequest;
import com.mfons_projects.walletapp.Dtos.request.RegistrationRequest;
import com.mfons_projects.walletapp.Dtos.response.DepositResponse;
import com.mfons_projects.walletapp.Dtos.response.RegistrationResponse;
import com.mfons_projects.walletapp.exception.CustomerAlreadyExistException;
import com.mfons_projects.walletapp.exception.UserNotFoundException;
import com.mfons_projects.walletapp.exception.WalletNotFoundException;
import com.mfons_projects.walletapp.service.interfaces.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class CustomerServiceTest {

    @Autowired
    private CustomerService customerService;

    @Test
    @Sql("/db/database.sql")
    public void testThatCustomerCanBeRegistered() throws CustomerAlreadyExistException {
        RegistrationRequest customerRequest = buildCustomerRegistration();
        RegistrationResponse registrationResponse =  customerService.register(customerRequest);
        log.info("response ->{}", registrationResponse);
        assertEquals("SUCCESS",registrationResponse.getStatus());
        assertNotNull(registrationResponse);
    }

   private static RegistrationRequest buildCustomerRegistration() {
        RegistrationRequest customerRequest = new RegistrationRequest();
        customerRequest.setFullName("Mercy Williams");
        customerRequest.setEmail("mercywilliams@gmail.com");
        customerRequest.setPhoneNumber("09434552352");
        customerRequest.setPassword("2354cv");
        return customerRequest;
    }

    @Test
    public void testThatCustomerCanDepositFunds() throws UserNotFoundException, WalletNotFoundException {
        Long customerId = 1L;
        BigDecimal depositAmount = new BigDecimal("3000");
        String narration = "This is a test";
        DepositRequest depositRequest = new DepositRequest();
        depositRequest.setCustomerId(customerId);
        depositRequest.setAmount(depositAmount);
        depositRequest.setNarration(narration);
        DepositResponse depositResponse = customerService.deposit(depositRequest);
        assertEquals("SUCCESS", depositResponse.getStatus().toString());
        assertNotNull(depositResponse);
    }
}
