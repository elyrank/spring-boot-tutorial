package com.liveperson.tutorial.spring.boot.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import javax.websocket.Session;

/**
 * @author elyran
 * @since 5/31/16.
 */
public class WsHandler extends TextWebSocketHandler {

    private static final Logger logger = LoggerFactory.getLogger(WsHandler.class);

    @Value("${ws.message}")
    private String wsMessage;


    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        session.sendMessage(new TextMessage("Welcome to my  ws boot app!"));
        logger.info("connection established: {}", session);
    }


    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        logger.info("received message: {}", message);
        session.sendMessage(new TextMessage(wsMessage + " -- " + message.getPayload()));
    }

}
