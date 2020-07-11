package com.mobilabsolutions;

import com.mobilabsolutions.enums.Currency;
import com.mobilabsolutions.model.Account;
import com.mobilabsolutions.repository.AccountRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MobilabFullStackDevTasksConfiguration.class})
@TestPropertySource("classpath:application.properties")
public class AccountRepositoryTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenAccountPersists_thenIdHasValue() {
        Account account = new Account();
        account.setOwner("Nariman");
        account.setBalance(100.0);
        account.setCurrency(Currency.DOLLAR);
        account.setCreatedOn(new Date());
        Account createdAccount = accountRepository.save(account);

        assertNotNull(createdAccount.getId());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenOwnerIsNull_thenThrowsDataIntegrityViolationException() {
        Account account = new Account();
        account.setBalance(100.0);
        account.setCurrency(Currency.DOLLAR);
        account.setCreatedOn(new Date());
        Account createdAccount = accountRepository.save(account);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenBalanceIsNull_thenThrowsDataIntegrityViolationException() {
        Account account = new Account();
        account.setOwner("Nariman");
        account.setCurrency(Currency.DOLLAR);
        account.setCreatedOn(new Date());
        Account createdAccount = accountRepository.save(account);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenCurrencyIsNull_thenThrowsDataIntegrityViolationException() {
        Account account = new Account();
        account.setOwner("Nariman");
        account.setBalance(100.0);
        account.setCreatedOn(new Date());
        Account createdAccount = accountRepository.save(account);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenCreatedOnIsNull_thenThrowsDataIntegrityViolationException() {
        Account account = new Account();
        account.setOwner("Nariman");
        account.setBalance(100.0);
        account.setCurrency(Currency.DOLLAR);
        Account createdAccount = accountRepository.save(account);
    }
}
