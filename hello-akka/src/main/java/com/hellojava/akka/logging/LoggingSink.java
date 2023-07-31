package com.hellojava.akka.logging;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * @description: LoggingSource
 * @author: Liu Ran
 * @date: 7/28/23 15:48
 */
public class LoggingSink extends AbstractActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    public static Props props() {
        return Props.create(LoggingSink.class, LoggingSink::new);
    }


    @Override
    public void preStart() throws Exception {
        log.info("存储日志开始");
    }

    @Override
    public void postStop() throws Exception {
        log.info("存储日志开结束");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("fail", p -> {
                    System.out.println("filed");
                    throw new RuntimeException("I failed.");
                })
        .build();
    }
}
