package com.pa.api.personalauditor.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
@Table(name="VEHICLE")
public class VehicleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "userId")
    private UserEntity user;

    @OneToMany(mappedBy = "vehicle")
    private List<MaintenanceRecordEntity> maintenanceRecords;

    @ManyToMany
    private List<DriverEntity> drivers;
}
