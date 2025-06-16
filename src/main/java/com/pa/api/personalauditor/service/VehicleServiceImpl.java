package com.pa.api.personalauditor.service;

import com.pa.api.personalauditor.entity.VehicleEntity;
import com.pa.api.personalauditor.entity.VehicleTransaction;
import com.pa.api.personalauditor.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pa.api.personalauditor.repository.VehicleRepository;
import com.pa.api.personalauditor.repository.VehicleTransactionRepository;

import java.util.List;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    @Override
    public List<VehicleEntity> findVehicles() {
        return List.of();
    }

    @Override
    public VehicleEntity createVehicle(VehicleEntity vehicleEntity) {
        return null;
    }

    @Override
    public VehicleEntity updateVehicle(VehicleEntity vehicleEntity) {
        return null;
    }

    @Override
    public VehicleEntity deleteVehicle(Long accountId) {
        return null;
    }

    @Override
    public VehicleEntity findVehicleById(Long vehicleId) {
        return null;
    }

    @Override
    public List<VehicleEntity> findVehiclesByUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<VehicleEntity> findVehiclesByType(String vehicleType) {
        return List.of();
    }

    @Override
    public List<VehicleEntity> findVehiclesByStatus(String status) {
        return List.of();
    }
}