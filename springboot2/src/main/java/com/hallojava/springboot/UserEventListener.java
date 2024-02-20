//package com.hallojava.springboot;
//
//import org.springframework.cloud.stream.annotation.EnableBinding;
//import org.springframework.cloud.stream.annotation.StreamListener;
//import org.springframework.cloud.stream.messaging.Sink;
//import org.springframework.messaging.Message;
//
///**
// * @ description: UserEventLinstener
// * @ author: Liu Ran
// * @ data: 2/14/23 15:53
// */
//
//@EnableBinding(Sink.class)
//public class UserEventListener {
//
//    @StreamListener(value = Sink.INPUT,condition = "header[type]=='ACC'")
//    public void onMessage(Message<UserEvent> event) {
//
//        System.out.println(event);
//    }
//
//}
