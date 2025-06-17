package com.pa.api.personalauditor.repository;

import com.pa.api.personalauditor.entity.MaintenanceRecordEntity;
import com.pa.api.personalauditor.entity.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MaintenanceRepository extends JpaRepository<MaintenanceRecordEntity, Long> {
    List<MaintenanceRecordEntity> findByVehicle(Vehicle vehicle);
}
