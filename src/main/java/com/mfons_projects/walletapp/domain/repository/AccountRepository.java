package com.mfons_projects.walletapp.domain.repository;

import com.mfons_projects.walletapp.domain.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
