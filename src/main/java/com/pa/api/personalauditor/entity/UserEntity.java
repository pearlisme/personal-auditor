package com.pa.api.personalauditor.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public Long userId;
    public String userName;
    public String password;
    public String email;
    public String firstName;
    public String lastName;
    public String phoneNumber;
    public String address;
    public String city;
    public String state;
    public String zipCode;
    public String country;
    public String dateOfBirth;
    public String appAccess;

    @OneToMany(mappedBy = "ownerId")
    List<VehicleEntity> vehicles;

}
