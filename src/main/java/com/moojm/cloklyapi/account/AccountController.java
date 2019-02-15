package com.moojm.cloklyapi.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private AccountService accountService;

    @RequestMapping(method = RequestMethod.POST, value = "/accounts")
    public void createNewAccount(@RequestBody Account account) {
        accountService.createNewAccount(account);
    }

    @RequestMapping("/accounts")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @RequestMapping("/accounts/{email}")
    public Account getAccountByEmail(@PathVariable String email) {
        return accountService.getAccountByEmail(email);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public void updateAccount(@RequestBody Account account) {
        accountService.updateAccount(account);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/accounts/{id}")
    public void deleteAccount(@PathVariable Long id) {
        accountService.deleteAccount(id);
    }
}
