package com.mfons_projects.walletapp.Dtos.request;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class DepositRequest {
    private Long customerId;
    private BigDecimal amount;
    private String narration;
}
