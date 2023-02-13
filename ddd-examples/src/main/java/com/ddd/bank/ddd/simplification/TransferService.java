package com.ddd.bank.ddd.simplification;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @ description: TransferService
 * @ author: Liu Ran
 * @ data: 2/2/23 10:02
 */

@Service
public class TransferService {

    private AccountRepository accountRepository;

    private ExchangeRageService exchangeRageService;

    private AccountTransferService accountTransferService;

    private AuditMessageProducer auditMessageProducer;

    public Boolean transfer(String sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {
        // 读取数据
        Account sourceAccount = accountRepository.findByUserId(sourceUserId);
        Account targetAccount = accountRepository.findByAccountNumber(targetAccountNumber);
        ExchangeRage exchangeRage = exchangeRageService.getExchangeRage(sourceAccount.getCurrency(), targetCurrency);

        // 业务逻辑
        accountTransferService.transfer(sourceAccount, targetAccount, targetAmount, targetCurrency, exchangeRage);

        // 保存数据
        accountRepository.save(sourceAccount);
        accountRepository.save(targetAccount);

        // 发送审计消息
        AuditMessage auditMessage = new AuditMessage(sourceAccount, targetAccount, targetAmount, targetCurrency);
        auditMessageProducer.send(auditMessage);

        return true;
    }
}
