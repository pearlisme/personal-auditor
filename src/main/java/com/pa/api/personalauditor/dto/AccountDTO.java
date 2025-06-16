package com.pa.api.personalauditor.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {

    public Long accountId;
    public String accountName;
    public String accountType;
    public String accountBalance;
    public String bankName;
    public String routingNumber;
    public String accountDescription;
    public String userId;
}
