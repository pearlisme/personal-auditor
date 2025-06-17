package com.pa.api.personalauditor.service;

import com.pa.api.personalauditor.dto.VehicleDTO;
import com.pa.api.personalauditor.entity.Vehicle;
import com.pa.api.personalauditor.mapper.VehicleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.pa.api.personalauditor.repository.VehicleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class VehicleServiceImpl implements VehicleService {

    Logger logger = Logger.getLogger(Vehicle.class.getName());

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    VehicleMapper vehicleMapper;

    @Override
    public List<VehicleDTO> findVehicles() {

        List<VehicleDTO> vehicleDTOs = new ArrayList<>();

        logger.info("Found " + vehicleDTOs.size() + " vehicles.");
        for (Vehicle vehicle : vehicleRepository.findAll()) {
            vehicleDTOs.add(vehicleMapper.vehicleEntityToVehicleDto(vehicle));
        }
        logger.info("Converted " + vehicleDTOs.size() + " vehicles to DTOs.");
        return vehicleDTOs;
    }

    @Override
    public VehicleDTO createVehicle(VehicleDTO vehicleDTO) {

        Vehicle vehicle = vehicleMapper.vehicleDTOToVehicleEntity(vehicleDTO);
        Vehicle savedVehicle  = vehicleRepository.save(vehicle);
        VehicleDTO savedVehicleDTO = vehicleMapper.vehicleEntityToVehicleDto(savedVehicle);
        return savedVehicleDTO;
    }

    @Override
    public VehicleDTO updateVehicle(VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleMapper.vehicleDTOToVehicleEntity(vehicleDTO);
        Vehicle updatedVehicle = vehicleRepository.save(vehicle);
        VehicleDTO updatedVehicleDTO = vehicleMapper.vehicleEntityToVehicleDto(updatedVehicle);
        logger.info("Updated vehicle with ID: " + updatedVehicle.getVehicleId());
        return updatedVehicleDTO;
    }

    @Override
    public VehicleDTO deleteVehicle(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        if (vehicle != null) {
            vehicleRepository.delete(vehicle);
            logger.info("Deleted vehicle with ID: " + vehicleId + " from the database.");
            return vehicleMapper.vehicleEntityToVehicleDto(vehicle);
        }
        return null;
    }

    @Override
    public VehicleDTO findVehicleById(Long vehicleId) {
        Vehicle vehicle = vehicleRepository.findById(vehicleId).orElse(null);
        return vehicle != null ? vehicleMapper.vehicleEntityToVehicleDto(vehicle) : null;
    }

    @Override
    public List<VehicleDTO> findVehiclesByUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<VehicleDTO> findVehiclesByType(String vehicleType) {
        return List.of();
    }

    @Override
    public List<VehicleDTO> findVehiclesByStatus(String status) {
        return List.of();
    }
}