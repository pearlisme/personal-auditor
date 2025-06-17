package com.pa.api.personalauditor.repository;

import com.pa.api.personalauditor.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    // Additional query methods can be defined here if needed
}
