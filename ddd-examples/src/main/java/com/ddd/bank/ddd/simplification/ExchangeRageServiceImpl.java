package com.ddd.bank.ddd.simplification;

import com.ddd.bank.infra.YahooForexService;

import java.math.BigDecimal;

/**
 * @ description: ExchangeRageServiceImpl
 * @ author: Liu Ran
 * @ data: 2/3/23 15:54
 */
public class ExchangeRageServiceImpl implements ExchangeRageService{

    private YahooForexService yahooForexService;

    @Override
    public ExchangeRage getExchangeRage(String sourceCurrency, String targetCurrency) {
        if (sourceCurrency.equals(targetCurrency)) {
            return new ExchangeRage(BigDecimal.ONE, sourceCurrency, targetCurrency);
        }
        BigDecimal forex = yahooForexService.getExchangeRate(sourceCurrency, targetCurrency);
        return new ExchangeRage(forex, sourceCurrency, targetCurrency);
    }
}
