package com.mfons_projects.walletapp.domain.repository;

import com.mfons_projects.walletapp.domain.models.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {
}
