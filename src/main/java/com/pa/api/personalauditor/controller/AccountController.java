package com.pa.api.personalauditor.controller;

import com.pa.api.personalauditor.dto.AccountDTO;
import com.pa.api.personalauditor.entity.Account;
import com.pa.api.personalauditor.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    Logger logger = Logger.getLogger(AccountController.class.getName());

    @Autowired
    AccountService accountService;

    @GetMapping("/load/{count}")
    @ResponseStatus(HttpStatus.OK)
    public List<AccountDTO> loadAccounts(@PathVariable Long count) {

        int i = 0;
        for (i = 1; i <= count; i++) {
            accountService.addAccount(new AccountDTO(null, "Savings" + i, "Active", "1000.00" + i, "IDFC LTD", "", "" + i, "" + i));
        }

        logger.log(Level.INFO,"Loaded %d accounts into the database.", i);
        return accountService.findAccounts();
    }

    @GetMapping("/")
    public List<AccountDTO> findAccounts() {
        return accountService.findAccounts();
    }

    @GetMapping("/{accountId}")
    public List<AccountDTO> findAccountsById(@PathVariable Long accountId) {
        return accountService.findAccounts();
    }

    @PostMapping
    public ResponseEntity<AccountDTO> addAccount(@RequestBody AccountDTO accountDTO) {
        AccountDTO accountDTOAdded = accountService.addAccount(accountDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(accountDTOAdded);
    }

    @PutMapping("/{accountId}")
    @ResponseStatus(HttpStatus.OK)
    public AccountDTO updateAccount(@PathVariable Long accountId
            ,@RequestBody final AccountDTO accountDTO) {

            AccountDTO accountDTOUpdate = new AccountDTO();
            if (accountService.findAccountById(accountId) != null){
            accountDTOUpdate = accountService.updateAccount(accountDTO);
            logger.info("Updated account: " + accountDTOUpdate);
            }
        return accountDTOUpdate;
    }

    @DeleteMapping
    public ResponseEntity<Account> deleteAccount(@RequestBody Account account) {
        accountService.deleteAccount(account.getAccountId());
        logger.info("Deleted account: " + account);
        return ResponseEntity.ok().body(account);
    }
}
