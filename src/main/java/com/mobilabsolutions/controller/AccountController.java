package com.mobilabsolutions.controller;

import com.mobilabsolutions.dto.AccountDto;
import com.mobilabsolutions.exception.ResourceNotFoundException;
import com.mobilabsolutions.model.Account;
import com.mobilabsolutions.service.AccountService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AccountController {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private AccountService accountService;

    @PostMapping("/accounts")
    public ResponseEntity createAccount(@RequestBody AccountDto accountDto) {
        Account account = modelMapper.map(accountDto, Account.class);
        Account createdAccount = accountService.createAccount(account);
        AccountDto createdAccountDto = modelMapper.map(createdAccount, AccountDto.class);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdAccount.getId()).toUri();
        return ResponseEntity.created(location).body(createdAccountDto);
    }

    @PutMapping("/accounts/{id}")
    public ResponseEntity updateAccount(@PathVariable(value = "id") Long id, @RequestBody AccountDto accountDto) throws ResourceNotFoundException {
        Account account = modelMapper.map(accountDto, Account.class);
        Account updatedAccount = accountService.updateAccount(id, account);
        AccountDto updatedAccountDto = modelMapper.map(updatedAccount, AccountDto.class);
        return ResponseEntity.ok(updatedAccountDto);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity getAccount(@PathVariable(value = "id") Long id) throws ResourceNotFoundException {
        Account account = accountService.getAccount(id);
        AccountDto accountDto = modelMapper.map(account, AccountDto.class);
        return ResponseEntity.ok(accountDto);
    }

    @GetMapping("/accounts")
    public ResponseEntity getAllAccounts(@RequestParam Integer page, @RequestParam Integer size) throws ResourceNotFoundException {
        List<Account> accounts = accountService.getAllAccounts(page, size);
        List<AccountDto> accountDtos = modelMapper.map(accounts, new TypeToken<List<AccountDto>>(){}.getType());
        return ResponseEntity.ok(accountDtos);
    }
}
