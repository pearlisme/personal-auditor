package com.pa.api.personalauditor.controller;

import com.pa.api.personalauditor.entity.AccountEntity;
import com.pa.api.personalauditor.entity.AuditEntity;
import com.pa.api.personalauditor.repository.AuditRepository;
import com.pa.api.personalauditor.service.AuditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class AccountController
{

    @Autowired
    AuditService auditService;

    @GetMapping("/v1/account")
    public String getAccountDetails()
    {
        return "Account details";
    }

    @GetMapping("/v1/account/transactions")
    public String getAccountTransactions()
    {
        AuditEntity auditEntity = new AuditEntity();
        auditEntity.setUserId("ZXMR123");

        auditService.auditEntry(auditEntity);
        return "Account transactions";
    }

    @PostMapping("/v1/account/create")
    public String createAccount(@RequestBody AccountEntity accountEntity)
    {

        return "Account created";

    }
}
