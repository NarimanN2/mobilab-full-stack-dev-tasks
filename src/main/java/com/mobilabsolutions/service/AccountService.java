package com.mobilabsolutions.service;

import com.mobilabsolutions.exception.ResourceNotFoundException;
import com.mobilabsolutions.model.Account;

import java.util.List;

public interface AccountService {

    Account createAccount(Account account);

    Account updateAccount(Long id, Account account) throws ResourceNotFoundException;

    Account getAccount(Long id) throws ResourceNotFoundException;

    List<Account> getAllAccounts(int page, int size);
}
