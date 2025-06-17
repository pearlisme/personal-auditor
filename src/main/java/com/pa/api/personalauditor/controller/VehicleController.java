package com.pa.api.personalauditor.controller;

import com.pa.api.personalauditor.dto.VehicleDTO;
import com.pa.api.personalauditor.entity.Account;
import com.pa.api.personalauditor.entity.Vehicle;
import com.pa.api.personalauditor.mapper.VehicleMapper;
import com.pa.api.personalauditor.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    Logger logger = Logger.getLogger(Vehicle.class.getName());

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/load/{count}")
    public ResponseEntity<List<VehicleDTO>> loadVehicles(@PathVariable int count) {

        int i = 0;
        for (i = 1; i <= count; i++) {

            VehicleDTO vehicleDTO = new VehicleDTO();
            vehicleDTO.setMake("Make_"+i);
            vehicleDTO.setModel("Model_"+i);
            vehicleDTO.setVin("VIN_"+i);
            vehicleDTO.setOwnerId("Owner_"+i);
            vehicleDTO.setInsurancePolicyNumber(UUID.randomUUID().toString());// Random ownerId for demonstration

            // Assigning userId in a round-robin fashion
            vehicleService.createVehicle(vehicleDTO);
        }
        logger.info("Loaded " + i + " accounts into the database.");
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<VehicleDTO> findVehicles() {
        return vehicleService.findVehicles();
    }

    @PostMapping
    public ResponseEntity<VehicleDTO> addAccount(@RequestBody VehicleDTO vehicleDTO) {
        VehicleDTO vehicleAdded = vehicleService.createVehicle(vehicleDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleAdded);
    }

    @PutMapping("/{vehicleId}")
    public ResponseEntity<VehicleDTO> updateVehicle(@PathVariable Long vehicleId,@RequestBody VehicleDTO vehicleDTO) {

        VehicleDTO vehicleUpdate = new VehicleDTO();
        if (vehicleService.findVehicleById(vehicleId) != null) {
            vehicleUpdate = vehicleService.updateVehicle(vehicleDTO);
            logger.info("Updated account: " + vehicleUpdate);
        }else {
            logger.warning("Vehicle with ID " + vehicleId + " not found.");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleUpdate);
    }

    @DeleteMapping("/{vehicleId}")
    public ResponseEntity<VehicleDTO> deleteVehicle(@PathVariable Long vehicleId) {
        vehicleService.deleteVehicle(vehicleId);
        logger.info("Deleted vehicle with ID: " + vehicleId);
        return ResponseEntity.ok().build();
    }
}
