package com.mfons_projects.walletapp.Dtos.request;

import com.mfons_projects.walletapp.domain.enums.StatusResponse;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
@Getter
@Setter
public class RetrieveTransactionRequest {
    private Long transactionId;
    private String recipientAccountNumber;
    private String senderAccountNumber;
    private BigDecimal amount;
    private String narrative;
    @Enumerated(EnumType.STRING)
    private StatusResponse status;
    private LocalDateTime timestamp;
}
