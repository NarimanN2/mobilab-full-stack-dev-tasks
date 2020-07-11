package com.mobilabsolutions.api;

import com.mobilabsolutions.enums.Currency;
import com.mobilabsolutions.exception.ServiceUnavailableException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CurrencyConverterImpl implements CurrencyConverter {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${api.exchange-rate}")
    private String baseURL;

    public double convert(double amount, Currency from, Currency to) {
        try {
            String url = baseURL + "latest?base=" + from.getValue() + "&symbols=" + to.getValue();
            ExchangeRate exchangeRate = restTemplate.getForObject(url, ExchangeRate.class);
            Double rate = exchangeRate.getRate(to.getValue());
            return rate * amount;
        } catch (Exception e) {
            throw new ServiceUnavailableException("Currency conversion services are unavailable.", e);
        }
    }
}
