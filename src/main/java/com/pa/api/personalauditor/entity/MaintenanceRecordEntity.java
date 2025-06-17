package com.pa.api.personalauditor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name="MAINTAINANCE_RECORD")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class MaintenanceRecordEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maintRecId;
    private String description;
    private LocalDate maintenanceDate;
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "vehicle_id", referencedColumnName = "vehicleId")
    private Vehicle vehicle;
}
