package com.mfons_projects.walletapp.domain.model;

import com.mfons_projects.walletapp.domain.enums.AccountType;
import com.mfons_projects.walletapp.domain.enums.StatusType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;

@Entity @Getter @Setter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private AccountType accountType;
    private BigInteger accountNumber;
    private BigDecimal amount;
    @Enumerated(EnumType.STRING)
    private StatusType statusType;
    private String bankName;
    private LocalDateTime createAt;
    private LocalDateTime updatedAt;
    @ManyToOne
    @JoinColumn(name= "customer_id")
    private Customers customer;

}
