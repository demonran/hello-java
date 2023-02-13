package com.ddd.bank.ddd.simplification;

import lombok.AllArgsConstructor;

import java.math.BigDecimal;

/**
 * @ description: AuditMessage
 * @ author: Liu Ran
 * @ data: 2/3/23 17:05
 */

public class AuditMessage {

    private String userId;

    private String sourceAccountNumber;

    private String targetAccountNumber;

    private BigDecimal targetAmount;

    private String targetCurrency;

    public AuditMessage(Account sourceAccount, Account targetAccount, BigDecimal targetAmount, String targetCurrency) {
        this.userId = sourceAccount.getUserId();
        this.sourceAccountNumber = sourceAccount.getAccountNumber();
        this.targetAccountNumber = targetAccount.getAccountNumber();
        this.targetAmount = targetAmount;
        this.targetCurrency = targetCurrency;
    }

    public String serialize() {
        return userId + ","
                + sourceAccountNumber + ","
                + targetAccountNumber + ","
                + targetAmount + ","
                + targetCurrency;
    }
}
