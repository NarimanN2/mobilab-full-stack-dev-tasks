package com.mobilabsolutions.repository;

import com.mobilabsolutions.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> getAllByCreatedOnBetweenOrderByCreatedOn(Date from, Date to);
}
