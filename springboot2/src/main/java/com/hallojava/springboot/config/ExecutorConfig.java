package com.hallojava.springboot.config;

import org.dromara.dynamictp.core.support.ThreadPoolBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.dromara.dynamictp.common.em.QueueTypeEnum.MEMORY_SAFE_LINKED_BLOCKING_QUEUE;

/**
 * ExecutorConfig
 *
 * @author Liu Ran
 */

@Configuration
public class ExecutorConfig {

    @Bean
    public ThreadPoolExecutor dtpExecutor1() {
        return ThreadPoolBuilder.newBuilder()
                                .threadPoolName("dtpExecutor1")
                                .threadFactory("test-dtp-common")
                                .corePoolSize(10)
                                .maximumPoolSize(15)
                                .keepAliveTime(40)
                                .timeUnit(TimeUnit.SECONDS)
                                .workQueue(MEMORY_SAFE_LINKED_BLOCKING_QUEUE.getName(), 2000)
                                .buildDynamic();
    }
}
