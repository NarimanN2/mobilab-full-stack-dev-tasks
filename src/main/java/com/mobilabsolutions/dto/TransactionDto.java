package com.mobilabsolutions.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mobilabsolutions.model.Account;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class TransactionDto {

    private Long id;

    @NotNull(message = "Source is required.")
    private Account source;

    @NotNull(message = "Destination is required.")
    private Account destination;

    @NotNull(message = "Amount is required.")
    private Double amount;

    private Date createdOn;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Account getSource() {
        return source;
    }

    public void setSource(Account source) {
        this.source = source;
    }

    public Account getDestination() {
        return destination;
    }

    public void setDestination(Account destination) {
        this.destination = destination;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
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
