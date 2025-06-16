package com.pa.api.personalauditor.service.impl;

import com.pa.api.personalauditor.dto.AccountDTO;
import com.pa.api.personalauditor.entity.AccountEntity;
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
        List<AccountEntity> accountEntities = accountRepository.findAll();
        AccountDTO accountDTOs = null;
        List<AccountDTO> accountDTOsList = new ArrayList<>();
        for (AccountEntity accountEntity : accountEntities) {
            System.out.println("Account ID: " + accountEntity.getAccountId());
            accountDTOs = accountMapper.accountEntityToAccountDto(accountEntity);
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
        AccountEntity accountEntity = accountMapper.accountDTOToAccountEntity(accountDTO);
        if (accountEntity.getAccountId() != null) {
            if (accountRepository.existsById(accountEntity.getAccountId())) {
                throw new IllegalArgumentException("Account with ID " + accountEntity.getAccountId() + " already exists.");
            }
        }
        accountRepository.save(accountEntity);
        AccountDTO accountDTOAdded = accountMapper.accountEntityToAccountDto(accountEntity);
        return accountDTOAdded;
    }

    @Override
    public AccountDTO updateAccount(AccountDTO accountDTO) {
        if (accountDTO.getAccountId() == null || !accountRepository.existsById(accountDTO.getAccountId())) {
            throw new IllegalArgumentException("Account with ID " + accountDTO.getAccountId() + " does not exist.");
        }
        AccountEntity accountEntity = accountMapper.accountDTOToAccountEntity(accountDTO);
        AccountEntity savedAccountEntity = accountRepository.save(accountEntity);
        return accountMapper.accountEntityToAccountDto(savedAccountEntity);
    }

    @Override
    public void deleteAccount(Long accountId) {
        if (!accountRepository.existsById(accountId)) {
            throw new IllegalArgumentException("Account with ID " + accountId + " does not exist.");
        }
        accountRepository.deleteById(accountId);
    }

    @Override
    public List<AccountEntity> findAccountsByUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<AccountEntity> findAccountsByType(String accountType) {
        return List.of();
    }

    @Override
    public List<AccountEntity> findAccountsByStatus(String status) {
        return List.of();
    }
}
