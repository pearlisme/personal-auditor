package com.pa.api.personalauditor.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class InsuranceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String provider;
    private String policyNumber;
    private LocalDate startDate;
    private LocalDate endDate;
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleId")
    private VehicleEntity vehicle;
}
