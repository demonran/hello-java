package com.ddd.bank.ddd.simplification;

/**
 * @ description: AccountRepository
 * @ author: Liu Ran
 * @ data: 2/3/23 14:49
 */
public interface AccountRepository {

    Account findByUserId(String userId);

    Account findByAccountNumber(String accountNumber);

    void save(Account account);
}
