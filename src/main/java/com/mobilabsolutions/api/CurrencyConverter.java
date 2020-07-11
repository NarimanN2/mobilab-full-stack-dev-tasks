package com.mobilabsolutions.api;

import com.mobilabsolutions.enums.Currency;

public interface CurrencyConverter {

    double convert(double amount, Currency from, Currency to);
}
