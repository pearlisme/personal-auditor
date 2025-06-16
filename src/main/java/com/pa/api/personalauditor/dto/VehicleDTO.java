package com.pa.api.personalauditor.dto;

import com.pa.api.personalauditor.entity.DriverEntity;
import com.pa.api.personalauditor.entity.MaintenanceRecordEntity;
import com.pa.api.personalauditor.entity.UserEntity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
public class VehicleDTO {

    public Long vehicleId;
    public String make;
    public String model;
    public String year;
    public String color;
    public String vin; // Vehicle Identification Number
    public String licensePlate;
    public String ownerId; // Reference to the owner (UserEntity)
    public String registrationDate;
    public String insuranceProvider;
    public String insurancePolicyNumber;
    public UserEntity user;
    public List<MaintenanceRecordEntity> maintenanceRecords;
    public List<DriverEntity> drivers;

}
