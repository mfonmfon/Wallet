package com.mfons_projects.walletapp.Dtos.response;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class WalletDepositResponse {
    private String amount;
    private String status;
}
