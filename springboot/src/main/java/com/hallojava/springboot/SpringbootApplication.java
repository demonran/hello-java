package com.hallojava.springboot;

import com.hallojava.springboot.user.UserEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.event.TransactionalEventListener;

@EnableAsync
@SpringBootApplication
// @EnableTransactionManagement
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }



    @TransactionalEventListener
    public void helloListener(UserEvent user) {
        System.out.println(user.getUsername());
        throw new RuntimeException();
    }

}
