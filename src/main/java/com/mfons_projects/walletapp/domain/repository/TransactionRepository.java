package com.mfons_projects.walletapp.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionRepository, Long> {
}
