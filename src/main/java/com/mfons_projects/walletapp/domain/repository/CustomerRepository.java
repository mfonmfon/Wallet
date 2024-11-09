package com.mfons_projects.walletapp.domain.repository;

import com.mfons_projects.walletapp.domain.model.Customers;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customers, Long> {
}
