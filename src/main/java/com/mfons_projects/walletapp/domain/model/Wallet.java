package com.mfons_projects.walletapp.domain.model;

import com.mfons_projects.walletapp.domain.enums.CurrencyType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Wallet {
    @Id
    private Long id;
    private BigDecimal balance;
    private CurrencyType currency;
    @ManyToOne
    @JoinColumn(name="customer_d")
    private Customers customers;
}
