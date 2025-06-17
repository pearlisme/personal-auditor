package com.pa.api.personalauditor.service.impl;

import com.pa.api.personalauditor.dto.AccountDTO;
import com.pa.api.personalauditor.entity.Account;
import com.pa.api.personalauditor.mapper.AccountMapper;
import com.pa.api.personalauditor.repository.AccountRepository;
import com.pa.api.personalauditor.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Autowired
    AccountMapper accountMapper;

    @Override
    public List<AccountDTO> findAccounts() {
        List<Account> accountEntities = accountRepository.findAll();
        AccountDTO accountDTOs = null;
        List<AccountDTO> accountDTOsList = new ArrayList<>();
        for (Account account : accountEntities) {
            System.out.println("Account ID: " + account.getAccountId());
            accountDTOs = accountMapper.accountEntityToAccountDto(account);
            accountDTOsList.add(accountDTOs);
        }
        return accountDTOsList;
    }

    @Override
    public AccountDTO findAccountById(Long accountId) {
        return null;
    }

    @Override
    public AccountDTO addAccount(AccountDTO accountDTO) {
        Account account = accountMapper.accountDTOToAccountEntity(accountDTO);
        if (account.getAccountId() != null) {
            if (accountRepository.existsById(account.getAccountId())) {
                throw new IllegalArgumentException("Account with ID " + account.getAccountId() + " already exists.");
            }
        }
        accountRepository.save(account);
        AccountDTO accountDTOAdded = accountMapper.accountEntityToAccountDto(account);
        return accountDTOAdded;
    }

    @Override
    public AccountDTO updateAccount(AccountDTO accountDTO) {
        if (accountDTO.getAccountId() == null || !accountRepository.existsById(accountDTO.getAccountId())) {
            throw new IllegalArgumentException("Account with ID " + accountDTO.getAccountId() + " does not exist.");
        }
        Account account = accountMapper.accountDTOToAccountEntity(accountDTO);
        Account savedAccount = accountRepository.save(account);
        return accountMapper.accountEntityToAccountDto(savedAccount);
    }

    @Override
    public void deleteAccount(Long accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new IllegalArgumentException("Account with ID " + accountId + " does not exist.");
        }
        accountRepository.deleteById(accountId);
    }

    @Override
    public List<Account> findAccountsByUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<Account> findAccountsByType(String accountType) {
        return List.of();
    }

    @Override
    public List<Account> findAccountsByStatus(String status) {
        return List.of();
    }
}
