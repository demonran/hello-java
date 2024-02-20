package com.hallojava.springboot;

import org.dromara.dynamictp.core.DtpRegistry;
import org.dromara.dynamictp.core.executor.DtpExecutor;
import org.dromara.dynamictp.core.spring.EnableDynamicTp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableDynamicTp
@EnableAsync
@SpringBootApplication
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
        DtpExecutor dtpExecutor = DtpRegistry.getDtpExecutor("dtpExecutor1");
        dtpExecutor.execute(() -> System.out.println("test"));
    }




}
