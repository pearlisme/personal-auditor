package com.pa.api.personalauditor.repository;

import com.pa.api.personalauditor.entity.VehicleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleEntity, Long> {
    // Additional query methods can be defined here if needed
}
