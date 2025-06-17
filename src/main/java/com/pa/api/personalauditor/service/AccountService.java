package com.pa.api.personalauditor.service;

import com.pa.api.personalauditor.dto.AccountDTO;
import com.pa.api.personalauditor.entity.Account;

import java.util.List;


public interface AccountService {
    List<AccountDTO> findAccounts();
    AccountDTO findAccountById(Long accountId);
    AccountDTO addAccount(AccountDTO accountDTO);
    AccountDTO updateAccount(AccountDTO accountDTO);
    void deleteAccount(Long accountId);
    List<Account> findAccountsByUserId(Long userId);
    List<Account> findAccountsByType(String accountType);
    List<Account> findAccountsByStatus(String status);
}
