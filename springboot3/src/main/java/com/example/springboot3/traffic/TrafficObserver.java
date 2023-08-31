package com.example.springboot3.traffic;

import com.example.springboot3.websocket.Message;
import com.example.springboot3.websocket.WebSocket;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hellojava.observer.Observer;
import com.hellojava.traffic.message.BlackOutMessage;
import com.hellojava.traffic.message.LightMessage;
import lombok.RequiredArgsConstructor;

/**
 * TrafficObserver
 *
 * @author Liu Ran
 */

@RequiredArgsConstructor
public class TrafficObserver implements Observer {

    private final WebSocket webSocket;
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void update(Object msg) {
        Message message = null;
        if (msg instanceof LightMessage lightMessage) {
             message = new Message("lamp", lightMessage.lamp().name(), true);
        } else if (msg instanceof BlackOutMessage blackOutMessage) {
            message = new Message("lamp", blackOutMessage.lamp().name(), false);
        }
        if (message != null) {
            try {
                webSocket.send(objectMapper.writeValueAsString(message));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
