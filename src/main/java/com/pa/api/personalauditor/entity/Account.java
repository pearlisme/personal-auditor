package com.pa.api.personalauditor.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class Account implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public Long accountId;
    public String accountName;
    public String accountType;
    public String accountBalance;
    public String accountNumber;
    public String bankName;
    public String routingNumber;
    public String accountDescription;
    public String userId;

    // Constructor, getters, and setters can be added here
}
