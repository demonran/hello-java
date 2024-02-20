package com.hallojava.springboot;

import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

/**
 * @ description: UserEventLinstener
 * @ author: Liu Ran
 * @ data: 2/14/23 15:53
 */

@Component
@RocketMQMessageListener(topic = "samps-fmc-resource", consumerGroup = "hellospring1")
public class ResourceListener implements RocketMQListener<Message> {

    public void onMessage(Message message) {
        System.out.println(message.getProperties());

    }
}
