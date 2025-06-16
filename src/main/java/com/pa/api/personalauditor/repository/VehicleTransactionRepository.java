package com.pa.api.personalauditor.repository;

import com.pa.api.personalauditor.entity.VehicleTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleTransactionRepository extends JpaRepository<VehicleTransaction, Long> {
    // Additional query methods can be defined here if needed
}
