package com.pa.api.personalauditor.controller;

import com.pa.api.personalauditor.dto.VehicleDTO;
import com.pa.api.personalauditor.entity.AccountEntity;
import com.pa.api.personalauditor.entity.VehicleEntity;
import com.pa.api.personalauditor.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/vehicles")
public class VehicleController {

    Logger logger = Logger.getLogger(VehicleEntity.class.getName());

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/load/{count}")
    public ResponseEntity<List<VehicleDTO>> loadVehicles(@PathVariable int count) {

        int i = 0;
        for (i = 1; i <= count; i++) {
       /*     vehicleService.createVehicle(new VehicleDTO(
                    null,
                    "Vehicle" + i,
                    "Model" + i,
                    "Type" + i,
                    "Color" + i,
                    "RegistrationNumber" + i,
                    "OwnerName" + i,
                    "InsuranceProvider" + i,
                    "PolicyNumber" + i
            ));*/
        }
        logger.info("Loaded " + i + " accounts into the database.");
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public List<VehicleEntity> findVehicles() {
        return vehicleService.findVehicles();
    }

    @PostMapping
    public ResponseEntity<VehicleEntity> addAccount(@RequestBody VehicleEntity  vehicleEntity) {
        VehicleEntity vehicleEntityAdded = vehicleService.createVehicle(vehicleEntity);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(vehicleEntityAdded);
    }

    @PutMapping
    public ResponseEntity<VehicleEntity> updateVehicle(@RequestBody VehicleEntity vehicleEntity) {

        VehicleEntity vehicleEntityUpdate = new VehicleEntity();
        if (vehicleEntity.getVehicleId() != null) {
            if (vehicleService.findVehicleById(vehicleEntity.getVehicleId()) != null) {
                vehicleEntityUpdate = vehicleService.updateVehicle(vehicleEntity);
                logger.info("Updated account: " + vehicleEntityUpdate);
            }
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(vehicleEntityUpdate);
    }

    @DeleteMapping
    public ResponseEntity<AccountEntity> deleteAccount(@RequestBody AccountEntity accountEntity) {
        vehicleService.deleteVehicle(accountEntity.getAccountId());
        logger.info("Deleted account: " + accountEntity);
        return ResponseEntity.ok().body(accountEntity);
    }
}
