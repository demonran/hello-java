package com.ddd.bank.ddd.simplification;

/**
 * @ description: ExchangeRageService
 * @ author: Liu Ran
 * @ data: 2/3/23 15:21
 */
public interface ExchangeRageService {

    ExchangeRage getExchangeRage(String sourceCurrency,
                                 String targetCurrency) ;

}
