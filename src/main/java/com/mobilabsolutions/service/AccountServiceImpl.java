package com.mobilabsolutions.service;

import com.mobilabsolutions.exception.ResourceNotFoundException;
import com.mobilabsolutions.model.Account;
import com.mobilabsolutions.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public Account createAccount(Account account) {
        account.setCreatedOn(new Date());
        return accountRepository.save(account);
    }

    @Override
    public Account updateAccount(Long id, Account account) throws ResourceNotFoundException {
        Account currentAccount = getAccount(id);
        account.setId(currentAccount.getId());
        account.setCreatedOn(currentAccount.getCreatedOn());
        return accountRepository.save(account);
    }

    @Override
    public Account getAccount(Long id) throws ResourceNotFoundException {
        return accountRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Account not found."));
    }

    @Override
    public List<Account> getAllAccounts(int page, int size) {
        Page<Account> accounts = accountRepository.findAll(PageRequest.of(page, size));
        return accounts.getContent();
    }
}
