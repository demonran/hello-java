package com.ddd.bank.ddd.simplification;

/**
 * @ description: AuditMessagePublisher
 * @ author: Liu Ran
 * @ data: 2/3/23 17:12
 */
public interface AuditMessageProducer {

    void send(AuditMessage auditMessage);

}
