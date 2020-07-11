package com.mobilabsolutions.service;

import com.mobilabsolutions.api.CurrencyConverter;
import com.mobilabsolutions.exception.InsufficientFundsException;
import com.mobilabsolutions.exception.ResourceNotFoundException;
import com.mobilabsolutions.model.Account;
import com.mobilabsolutions.model.Transaction;
import com.mobilabsolutions.repository.AccountRepository;
import com.mobilabsolutions.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CurrencyConverter currencyConverter;

    @Override
    public Transaction createTransaction(Transaction transaction) throws ResourceNotFoundException, InsufficientFundsException {
        transaction.setCreatedOn(new Date());
        Account source = accountRepository.findById(transaction.getSource().getId()).orElseThrow(() -> new ResourceNotFoundException("Account not found."));
        Account destination = accountRepository.findById(transaction.getDestination().getId()).orElseThrow(() -> new ResourceNotFoundException("Account not found."));

        if (source.getCurrency() == destination.getCurrency()) {
            source.withdraw(transaction.getAmount());
            destination.deposit(transaction.getAmount());
        }

        else {
            double convertedAmount = currencyConverter.convert(transaction.getAmount(), source.getCurrency(), destination.getCurrency());
            source.withdraw(transaction.getAmount());
            destination.deposit(convertedAmount);
        }

        accountRepository.save(source);
        accountRepository.save(destination);
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> getAllTransactionsBetween(Date from, Date to) {
        return transactionRepository.getAllByCreatedOnBetweenOrderByCreatedOn(from, to);
    }
}
