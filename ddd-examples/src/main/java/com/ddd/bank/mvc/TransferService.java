package com.ddd.bank.mvc;

import com.ddd.bank.exception.DailyLimitExceededException;
import com.ddd.bank.exception.InsufficientFundsException;
import com.ddd.bank.exception.InvalidCurrencyException;
import com.ddd.bank.infra.AccountPO;
import com.ddd.bank.infra.AccountJpaRepository;
import com.ddd.bank.infra.KafkaTemplate;
import com.ddd.bank.infra.YahooForexService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @ description: TransferService
 * @ author: Liu Ran
 * @ data: 2/2/23 10:02
 */

@Service
public class TransferService {
    private static final String TOPIC_AUDIT_LOG = "TOPIC_AUDIT_LOG";
    private AccountJpaRepository accountRepository;
    private YahooForexService yahooForexService;
    private KafkaTemplate kafkaTemplate;
    public Boolean transfer(String sourceUserId, String targetAccountNumber, BigDecimal targetAmount, String targetCurrency) {
        // 1. 从数据库读取数据，忽略所有校验逻辑如账号是否存在等
        AccountPO sourceAccountPO = accountRepository.findByUserId(sourceUserId);
        AccountPO targetAccountPO = accountRepository.findByAccountNumber(targetAccountNumber);

        // 2. 业务参数校验
        if (!targetAccountPO.getCurrency().equals(targetCurrency)) {
            throw new InvalidCurrencyException();
        }

        // 3. 获取外部数据，并且包含一定的业务逻辑
        BigDecimal exchangeRate = BigDecimal.ONE;
        if (!sourceAccountPO.getCurrency().equals(targetCurrency)) {
            exchangeRate = yahooForexService.getExchangeRate(sourceAccountPO.getCurrency(), targetCurrency);
        }
        BigDecimal sourceAmount = targetAmount.divide(exchangeRate, RoundingMode.DOWN);

        // 4. 业务参数校验
        if (sourceAccountPO.getAvailable().compareTo(sourceAmount) < 0) {
            throw new InsufficientFundsException();
        }

        if (sourceAccountPO.getDailyLimit().compareTo(sourceAmount) < 0) {
            throw new DailyLimitExceededException();
        }

        // 5. 计算新值，并且更新字段
        BigDecimal newSource = sourceAccountPO.getAvailable().subtract(sourceAmount);
        BigDecimal newTarget = targetAccountPO.getAvailable().add(targetAmount);
        sourceAccountPO.setAvailable(newSource);
        targetAccountPO.setAvailable(newTarget);

        // 6. 更新到数据库
        accountRepository.save(sourceAccountPO);
        accountRepository.save(targetAccountPO);

        // 7. 发送审计消息
        String message = sourceUserId + "," + targetAccountNumber + "," + targetAmount + "," + targetCurrency;
        kafkaTemplate.send(TOPIC_AUDIT_LOG, message);
        return true;
    }
}
