package com.example.springboot3.linstener;

import com.example.springboot3.traffic.TrafficObserver;
import com.example.springboot3.websocket.WebSocket;
import com.hellojava.observer.Subject;
import com.hellojava.traffic.TrafficPortal;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * StartedLinsenter
 *
 * @author Liu Ran
 */

@Component
@RequiredArgsConstructor
public class StartedListener implements ApplicationListener<ApplicationStartedEvent> {

    private final WebSocket webSocket;
    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
        Subject.INSTANCE.attach(new TrafficObserver(webSocket));
        TrafficPortal.start();
    }
}
