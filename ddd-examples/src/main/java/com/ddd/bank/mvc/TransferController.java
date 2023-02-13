package com.ddd.bank.mvc;

import com.ddd.bank.SecurityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @ description: TransferController
 * @ author: Liu Ran
 * @ data: 2/2/23 09:55
 */

@RestController("transfer")
public class TransferController {

    private TransferService transferService;

    @PostMapping
    public Boolean transfer(String targetAccountNumber, BigDecimal amount) {
        String userId = SecurityUtils.currentUserId();
        return transferService.transfer(userId, targetAccountNumber, amount, "CNY");

    }
}
