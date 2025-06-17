package com.pa.api.personalauditor.service;

import com.pa.api.personalauditor.dto.VehicleDTO;
import com.pa.api.personalauditor.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    List<VehicleDTO> findVehicles();
    VehicleDTO createVehicle(VehicleDTO vehicleDTO);
    VehicleDTO updateVehicle(VehicleDTO vehicleDTO);
    VehicleDTO deleteVehicle(Long accountId);

    VehicleDTO findVehicleById(Long vehicleId);
    List<VehicleDTO> findVehiclesByUserId(Long userId);
    List<VehicleDTO> findVehiclesByType(String vehicleType);
    List<VehicleDTO> findVehiclesByStatus(String status);
}

