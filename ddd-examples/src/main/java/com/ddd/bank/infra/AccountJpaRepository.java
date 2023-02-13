package com.ddd.bank.infra;

/**
 * @ description: AccountRepository
 * @ author: Liu Ran
 * @ data: 2/2/23 10:04
 */
public interface AccountJpaRepository {

    AccountPO findByUserId(String userId);

    AccountPO findByAccountNumber(String accountNumber);

    void save(AccountPO sourceAccountPO);
}
