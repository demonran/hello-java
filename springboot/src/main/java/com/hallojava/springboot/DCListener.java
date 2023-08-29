package com.hallojava.springboot;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @ description: UserEventLinstener
 * @ author: Liu Ran
 * @ data: 2/14/23 15:53
 */

@Component
@RocketMQMessageListener(topic = "DC", consumerGroup = "hellospring")
public class DCListener implements RocketMQListener<String> {

    public void onMessage(String message) {
        System.out.println(message);

    }
}
