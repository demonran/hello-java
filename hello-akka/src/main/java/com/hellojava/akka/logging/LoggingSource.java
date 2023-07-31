package com.hellojava.akka.logging;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import static org.apache.log4j.MDC.getContext;

/**
 * @description: LoggingSource
 * @author: Liu Ran
 * @date: 7/28/23 15:48
 */
public class LoggingSource extends AbstractActor {

    ActorRef sink = getContext().actorOf(LoggingSink.props(), "sink");

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    public static Props props() {
        return Props.create(LoggingSource.class, LoggingSource::new);
    }


    @Override
    public void preStart() throws Exception {

        log.info("开始采集日志");
    }

    @Override
    public void postStop() throws Exception {
        log.info("采集日志结束");
    }

    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .matchEquals("123", p -> {

                    System.out.println("Second: " + sink);
                }) .matchEquals("stop", p -> {
                    getContext().stop(getSelf());
                }).matchEquals("fail", p -> sink.tell("fail", ActorRef.noSender()))
                .build();
    }
}
