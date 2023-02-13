package com.ddd.bank.ddd.simplification;

import com.ddd.bank.exception.DailyLimitExceededException;
import com.ddd.bank.exception.InsufficientFundsException;
import com.ddd.bank.exception.InvalidCurrencyException;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ description: Account
 * @ author: Liu Ran
 * @ data: 2/3/23 10:09
 */

@Data
public class Account {

    private String id;

    private String accountNumber;

    private String currency;

    private String userId;

    private BigDecimal available;

    private BigDecimal dailyLimit;

    // 转出
    public void withdraw(BigDecimal money) {

        if (this.getAvailable().compareTo(money) < 0) {
            throw new InsufficientFundsException();
        }

        if (this.getDailyLimit().compareTo(money) < 0) {
            throw new DailyLimitExceededException();
        }
       this.available = this.getAvailable().subtract(money);

    }

    // 转入
    public void deposit(BigDecimal money, String currency) {
        if (!this.getCurrency().equals(currency)) {
            throw new InvalidCurrencyException();
        }
        this.available = this.available.add(money);

    }
}
