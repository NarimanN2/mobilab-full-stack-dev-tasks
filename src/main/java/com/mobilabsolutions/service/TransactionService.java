package com.mobilabsolutions.service;

import com.mobilabsolutions.exception.InsufficientFundsException;
import com.mobilabsolutions.exception.ResourceNotFoundException;
import com.mobilabsolutions.model.Transaction;

import java.util.Date;
import java.util.List;

public interface TransactionService {

    Transaction createTransaction(Transaction transaction) throws ResourceNotFoundException, InsufficientFundsException;

    List<Transaction> getAllTransactionsBetween(Date from, Date to);
}
