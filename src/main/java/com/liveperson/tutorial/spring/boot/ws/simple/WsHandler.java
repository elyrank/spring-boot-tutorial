package com.liveperson.tutorial.spring.boot.ws.simple;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.websocket.CloseReason;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

/**
 * @author elyran
 * @since 5/31/16.
 */
@Component
@ServerEndpoint("/simple")
public class WsHandler {

    private static final Logger logger = LoggerFactory.getLogger(WsHandler.class);

    @OnMessage
    public String echoMessage(Session session, String message) throws Exception {
        logger.info("received message: {}", message);
        return message;
    }

    @OnOpen
    public void open(Session session) throws Exception {
        logger.info("session opened: {}", session.getRequestURI());
        if (true) {
            session.close(new CloseReason(() -> 4401, "test 4401 code"));
        }
    }




}
