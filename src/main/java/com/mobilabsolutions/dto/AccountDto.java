package com.mobilabsolutions.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mobilabsolutions.enums.Currency;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AccountDto {

    private Long id;

    @NotBlank(message = "Owner is required.")
    private String owner;

    @NotNull(message = "Balance is required.")
    @Min(value = 0, message = "Balance can not be negative.")
    private Double balance;

    @NotNull(message = "Currency is required.")
    private Currency currency;

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

    @JsonProperty("createdOn")
    public Date getCreatedOn() {
        return createdOn;
    }

    @JsonIgnore
    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
