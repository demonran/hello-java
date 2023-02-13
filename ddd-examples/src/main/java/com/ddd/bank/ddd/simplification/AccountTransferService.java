package com.ddd.bank.ddd.simplification;

import java.math.BigDecimal;

/**
 * @ description: AccountTransferService
 * @ author: Liu Ran
 * @ data: 2/6/23 10:23
 */
public class AccountTransferService {

    public void transfer(Account sourceAccount, Account targetAccount, BigDecimal targetAmount, String targetCurrency, ExchangeRage exchangeRage) {
        BigDecimal sourceAmount = exchangeRage.exchangeTo(targetAmount);
        sourceAccount.withdraw(sourceAmount);
        targetAccount.deposit(targetAmount, targetCurrency);
    }
}
