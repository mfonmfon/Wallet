package com.mfons_projects.walletapp.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;

import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
public class Wallet {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private BigDecimal balance;
    private String accountNumber;
}
