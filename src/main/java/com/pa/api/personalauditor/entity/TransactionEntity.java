package com.pa.api.personalauditor.entity;

import lombok.Data;

@Data
public class TransactionEntity {
    public String transactionId;
    public String transactionDate;
    public String transactionAmount;
    public String transactionType;
    public String transactionNote;
    public String transactionCategory;
    public String transactionAccount;
    public String transactionLabel;

}
