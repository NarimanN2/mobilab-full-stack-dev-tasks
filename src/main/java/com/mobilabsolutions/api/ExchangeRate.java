package com.mobilabsolutions.api;

import java.util.Date;
import java.util.Map;
import java.util.NoSuchElementException;

public class ExchangeRate {

    private Map<String, Double> rates;

    private String base;

    private String date;

    public Map<String, Double> getRates() {
        return rates;
    }

    public void setRates(Map<String, Double> rates) {
        this.rates = rates;
    }

    public Double getRate(String currency) {
        Double rate = rates.get(currency);

        if (rate == null)
            throw new NoSuchElementException("Currency does not exist.");

        return rate;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
