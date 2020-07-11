package com.mobilabsolutions;

import com.mobilabsolutions.enums.Currency;
import com.mobilabsolutions.model.Account;
import com.mobilabsolutions.model.Transaction;
import com.mobilabsolutions.repository.AccountRepository;
import com.mobilabsolutions.repository.TransactionRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MobilabFullStackDevTasksConfiguration.class})
@TestPropertySource("classpath:application.properties")
public class TransactionRepositoryTest {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private AccountRepository accountRepository;

    @Test
    public void whenTransactionPersists_thenIdHasValue() {
        Account sourceAccount = new Account();
        sourceAccount.setOwner("Nariman");
        sourceAccount.setBalance(100.0);
        sourceAccount.setCurrency(Currency.DOLLAR);
        sourceAccount.setCreatedOn(new Date());
        sourceAccount = accountRepository.save(sourceAccount);

        Account destinationAccount = new Account();
        destinationAccount.setOwner("Saeedeh");
        destinationAccount.setBalance(150.0);
        destinationAccount.setCurrency(Currency.EURO);
        destinationAccount.setCreatedOn(new Date());
        destinationAccount = accountRepository.save(destinationAccount);

        Transaction transaction = new Transaction();
        transaction.setSource(sourceAccount);
        transaction.setDestination(destinationAccount);
        transaction.setAmount(50.0);
        transaction.setCreatedOn(new Date());
        Transaction createdTransaction = transactionRepository.save(transaction);

        assertNotNull(createdTransaction.getId());
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenSourceIsNull_thenThrowsDataIntegrityViolationException() {
        Account destinationAccount = new Account();
        destinationAccount.setOwner("Saeedeh");
        destinationAccount.setBalance(150.0);
        destinationAccount.setCurrency(Currency.EURO);
        destinationAccount.setCreatedOn(new Date());
        destinationAccount = accountRepository.save(destinationAccount);

        Transaction transaction = new Transaction();
        transaction.setDestination(destinationAccount);
        transaction.setAmount(50.0);
        transaction.setCreatedOn(new Date());
        Transaction createdTransaction = transactionRepository.save(transaction);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenDestinationIsNull_thenThrowsDataIntegrityViolationException() {
        Account sourceAccount = new Account();
        sourceAccount.setOwner("Nariman");
        sourceAccount.setBalance(100.0);
        sourceAccount.setCurrency(Currency.DOLLAR);
        sourceAccount.setCreatedOn(new Date());
        sourceAccount = accountRepository.save(sourceAccount);

        Transaction transaction = new Transaction();
        transaction.setSource(sourceAccount);
        transaction.setAmount(50.0);
        transaction.setCreatedOn(new Date());
        Transaction createdTransaction = transactionRepository.save(transaction);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenAmountIsNull_thenThrowsDataIntegrityViolationException() {
        Account sourceAccount = new Account();
        sourceAccount.setOwner("Nariman");
        sourceAccount.setBalance(100.0);
        sourceAccount.setCurrency(Currency.DOLLAR);
        sourceAccount.setCreatedOn(new Date());
        sourceAccount = accountRepository.save(sourceAccount);

        Account destinationAccount = new Account();
        destinationAccount.setOwner("Saeedeh");
        destinationAccount.setBalance(150.0);
        destinationAccount.setCurrency(Currency.EURO);
        destinationAccount.setCreatedOn(new Date());
        destinationAccount = accountRepository.save(destinationAccount);

        Transaction transaction = new Transaction();
        transaction.setSource(sourceAccount);
        transaction.setDestination(destinationAccount);
        transaction.setCreatedOn(new Date());
        Transaction createdTransaction = transactionRepository.save(transaction);
    }

    @Test(expected = DataIntegrityViolationException.class)
    public void whenCreatedOnIsNull_thenThrowsDataIntegrityViolationException() {
        Account sourceAccount = new Account();
        sourceAccount.setOwner("Nariman");
        sourceAccount.setBalance(100.0);
        sourceAccount.setCurrency(Currency.DOLLAR);
        sourceAccount.setCreatedOn(new Date());
        sourceAccount = accountRepository.save(sourceAccount);

        Account destinationAccount = new Account();
        destinationAccount.setOwner("Saeedeh");
        destinationAccount.setBalance(150.0);
        destinationAccount.setCurrency(Currency.EURO);
        destinationAccount.setCreatedOn(new Date());
        destinationAccount = accountRepository.save(destinationAccount);

        Transaction transaction = new Transaction();
        transaction.setSource(sourceAccount);
        transaction.setDestination(destinationAccount);
        transaction.setAmount(50.0);
        Transaction createdTransaction = transactionRepository.save(transaction);
    }
}
