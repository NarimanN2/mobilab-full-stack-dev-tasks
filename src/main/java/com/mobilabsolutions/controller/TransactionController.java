package com.mobilabsolutions.controller;

import com.mobilabsolutions.dto.TransactionDto;
import com.mobilabsolutions.exception.InsufficientFundsException;
import com.mobilabsolutions.exception.ResourceNotFoundException;
import com.mobilabsolutions.model.Transaction;
import com.mobilabsolutions.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.Date;
import java.util.List;

@RestController
public class TransactionController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private TransactionService transactionService;

    @PostMapping("/transactions")
    public ResponseEntity createTransaction(@RequestBody TransactionDto transactionDto) throws ResourceNotFoundException, InsufficientFundsException {
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);
        Transaction createdTransaction = transactionService.createTransaction(transaction);
        TransactionDto createdTransactionDto = modelMapper.map(createdTransaction, TransactionDto.class);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTransactionDto.getId()).toUri();
        return ResponseEntity.created(location).body(createdTransactionDto);
    }

    @GetMapping("/transactions")
    public ResponseEntity getAllTransactionsByDate(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date from, @RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") Date to) {
        List<Transaction> transactions = transactionService.getAllTransactionsBetween(from, to);
        List<TransactionDto> transactionDtos = modelMapper.map(transactions, new TypeToken<List<TransactionDto>>(){}.getType());
        return ResponseEntity.ok(transactionDtos);
    }
}
