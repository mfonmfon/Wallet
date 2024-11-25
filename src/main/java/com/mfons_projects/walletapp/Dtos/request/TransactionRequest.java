package com.mfons_projects.walletapp.Dtos.request;

import com.mfons_projects.walletapp.domain.enums.StatusResponse;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class TransactionRequest {
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private BigDecimal amount;
    private LocalDateTime timestamp;
    private String narrative;
    private StatusResponse status;

}
