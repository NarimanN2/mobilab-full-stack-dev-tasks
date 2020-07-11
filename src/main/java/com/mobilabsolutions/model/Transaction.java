package com.mobilabsolutions.model;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "source_id", nullable = false)
    private Account source;

    @ManyToOne
    @JoinColumn(name = "destination_id", nullable = false)
    private Account destination;

    @Column(nullable = false)
    private Double amount;

    @Column(name = "created_on", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", source=" + source +
                ", destination=" + destination +
                ", amount=" + amount +
                ", createdOn=" + createdOn +
                '}';
    }
}
