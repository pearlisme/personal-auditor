package com.pa.api.personalauditor.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TransactionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    public Long transactionId;
    public String transactionDate;
    public String transactionAmount;
    public String transactionType;
    public String transactionNote;
    public String transactionCategory;
    public String transactionAccount;
    public String transactionLabel;

}
