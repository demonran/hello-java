package com.ddd.bank.ddd.simplification;

import com.ddd.bank.infra.KafkaTemplate;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @ description: AuditMessageProducerImpl
 * @ author: Liu Ran
 * @ data: 2/6/23 09:23
 */

@Component
@AllArgsConstructor
public class AuditMessageProducerImpl implements AuditMessageProducer {

    private static final String TOPIC_AUDIT_LOG = "TOPIC_AUDIT_LOG";

    private final KafkaTemplate kafkaTemplate;

    @Override
    public void send(AuditMessage auditMessage) {
        kafkaTemplate.send(TOPIC_AUDIT_LOG, auditMessage.serialize());
    }
}
