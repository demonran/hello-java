package com.hallojava.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.event.TransactionalEventListener;

import java.util.PriorityQueue;

@SpringBootApplication
//@EnableTransactionManagement
public class SpringbootApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootApplication.class, args);
    }



    @TransactionalEventListener(fallbackExecution = true)
    public void helloListener(UserEvent user) {
        System.out.println(user.getUsername());
        throw new RuntimeException();
    }

}
