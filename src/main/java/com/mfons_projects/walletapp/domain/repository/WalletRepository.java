package com.mfons_projects.walletapp.domain.repository;

import com.mfons_projects.walletapp.domain.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
