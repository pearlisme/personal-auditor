package com.pa.api.personalauditor.entity;

import jakarta.persistence.*;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Entity
@Setter
@Getter
public class VehicleTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public Long transactionId;
    public String vehicleId; // Reference to the VehicleEntity
    public String userId; // Reference to the UserEntity
    public String transactionType; // e.g., "purchase", "sale", "maintenance"
    public String transactionDate;
    public String amount; // Amount involved in the transaction
    public String description; // Additional details about the transaction
    public String status; // e.g., "completed", "pending", "cancelled"

    // Constructor, getters, and setters can be added here
}
