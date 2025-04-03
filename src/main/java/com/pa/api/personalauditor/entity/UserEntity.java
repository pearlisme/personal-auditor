package com.pa.api.personalauditor.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

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

}
