package com.ddd.bank.infra;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @ description: Account
 * @ author: Liu Ran
 * @ data: 2/2/23 10:05
 */

@Data
public class AccountPO {

    private String id;

    private String currency;

    private String userId;

    private BigDecimal available;

    private BigDecimal dailyLimit;
}
