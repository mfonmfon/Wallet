package com.mfons_projects.walletapp.domain.repository;

import com.mfons_projects.walletapp.domain.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    boolean findByEmail(String email);

}
