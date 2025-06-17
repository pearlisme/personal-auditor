package com.pa.api.personalauditor.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name="DRIVER")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class DriverEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String licenseNumber;
    private String email;
    private String phone;

    @ManyToMany(mappedBy = "drivers")
    private List<Vehicle> vehicles;

    // Getters and Setters

}
