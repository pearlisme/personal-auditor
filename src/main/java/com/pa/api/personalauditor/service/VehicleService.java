package com.pa.api.personalauditor.service;

import com.pa.api.personalauditor.entity.VehicleEntity;

import java.util.List;

public interface VehicleService {

    List<VehicleEntity> findVehicles();
    VehicleEntity createVehicle(VehicleEntity vehicleEntity);
    VehicleEntity updateVehicle(VehicleEntity vehicleEntity);
    VehicleEntity deleteVehicle(Long accountId);

    VehicleEntity findVehicleById(Long vehicleId);
    List<VehicleEntity> findVehiclesByUserId(Long userId);
    List<VehicleEntity> findVehiclesByType(String vehicleType);
    List<VehicleEntity> findVehiclesByStatus(String status);
}

