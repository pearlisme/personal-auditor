package com.pa.api.personalauditor.service;

import com.pa.api.personalauditor.dto.AccountDTO;
import com.pa.api.personalauditor.entity.AccountEntity;

import java.util.List;


public interface AccountService {
    List<AccountDTO> findAccounts();
    AccountDTO findAccountById(Long accountId);
    AccountDTO addAccount(AccountDTO accountDTO);
    AccountDTO updateAccount(AccountDTO accountDTO);
    void deleteAccount(Long accountId);
    List<AccountEntity> findAccountsByUserId(Long userId);
    List<AccountEntity> findAccountsByType(String accountType);
    List<AccountEntity> findAccountsByStatus(String status);
}
