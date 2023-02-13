package com.ddd.bank.ddd.simplification;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ description: ExchangeRage
 * @ author: Liu Ran
 * @ data: 2/3/23 15:21
 */
@Data
@AllArgsConstructor
public class ExchangeRage {
    private BigDecimal forex;

    private String sourceCurrency;

    private String targetCurrency;

    public BigDecimal exchangeTo(BigDecimal targetAmount) {
        return targetAmount.divide(forex, BigDecimal.ROUND_DOWN);
    }
}
