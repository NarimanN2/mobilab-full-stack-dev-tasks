package com.mobilabsolutions.model;

import com.mobilabsolutions.enums.Currency;
import com.mobilabsolutions.exception.InsufficientFundsException;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String owner;

    @Column(nullable = false)
    private Double balance;

    @Column(nullable = false)
    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @Column(name = "created_on", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Date createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public void deposit(double amount) {
        this.balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException {

        if (balance - amount < 0)
            throw new InsufficientFundsException("Account has insufficient funds for this operation.");

        this.balance -= amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", balance=" + balance +
                ", currency=" + currency +
                ", createdOn=" + createdOn +
                '}';
    }
}
