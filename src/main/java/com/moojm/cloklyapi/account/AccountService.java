package com.moojm.cloklyapi.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        List<Account> accounts = new ArrayList<>();
        accountRepository.findAll().forEach(accounts::add);
        return accounts;
    }

    public void createNewAccount(Account account) {
        // need to hash password before saving
        accountRepository.save(account);
    }

    public Account getAccountByEmail(String email) {
        Optional<Account> optional = accountRepository.findAccountByEmail(email);
        if (!optional.isPresent()) {
            throw new NoSuchElementException("Account does not exist.");
        }
        return optional.get();
    }

    public Account getAccountById(Long id) {
        Optional<Account> optional = accountRepository.findById(id);
        if (!optional.isPresent()) {
            throw new NoSuchElementException("Account does not exist.");
        }
        return optional.get();
    }

    public void updateAccount(Account account) {
        if (!accountRepository.findById(account.getId()).isPresent()) {
            throw new NoSuchElementException("Account does not exist.");
        }
        accountRepository.save(account);
    }

    public void deleteAccount(Long id) {
        Optional<Account> optional = accountRepository.findById(id);
        if (!optional.isPresent()) {
            throw new NoSuchElementException("Account does not exist.");
        }
        accountRepository.delete(optional.get());
    }
}
