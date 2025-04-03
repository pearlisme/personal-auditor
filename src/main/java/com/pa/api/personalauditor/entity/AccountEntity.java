package com.pa.api.personalauditor.entity;

import lombok.Data;

@Data
public class AccountEntity {
    public String accountId;
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
