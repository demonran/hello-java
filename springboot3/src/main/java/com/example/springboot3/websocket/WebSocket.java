package com.example.springboot3.websocket;

import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * WebSocket
 *
 * @author Liu Ran
 */

@Slf4j
@Component
@ServerEndpoint("/ws")
public class WebSocket {

    private Session session;

    private static CopyOnWriteArrayList<WebSocket> webSocketMap = new CopyOnWriteArrayList<>();


    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketMap.add(this);
        System.out.println("连接成功");
    }

    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }


    @OnClose
    public void onClose() {
        webSocketMap.remove(this);
        System.out.println("连接成功");
    }


    public void send(String message) {
        try {
            if (webSocketMap.isEmpty()) {
                return;
            }
            System.out.println("发送消息：" + message);
            webSocketMap.get(0).session.getBasicRemote().sendText(message);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
