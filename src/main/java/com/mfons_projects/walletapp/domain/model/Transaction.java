package com.mfons_projects.walletapp.domain.model;

import com.mfons_projects.walletapp.domain.enums.StatusType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
@Entity @Getter @Setter
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal amount;
    private StatusType status;
    private LocalDateTime createAt;
    @ManyToOne
    @JoinColumn(name = "to_wallet_id")
    private Wallet to_wallet;

    @ManyToOne
    @JoinColumn(name = "from_wallet_id")
    private Wallet from_wallet;
}
