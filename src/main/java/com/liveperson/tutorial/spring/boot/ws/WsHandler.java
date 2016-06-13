package com.liveperson.tutorial.spring.boot.ws;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;

/**
 * @author elyran
 * @since 5/31/16.
 */
@Component
@ServerEndpoint("/ws")
public class WsHandler {

    private static final Logger logger = LoggerFactory.getLogger(WsHandler.class);

    @OnMessage
    public String echoMessage(Session session, String message) throws Exception {
        logger.info("received message: {}", message);
        return message;
    }

    @OnOpen
    public void open(Session session) throws Exception {
        session.getAsyncRemote().sendText("Welcome to spring boot!");
        logger.info("session opened: {}", session.getRequestURI());
    }

    @OnClose
    public void close(Session session) throws Exception {
        logger.info("session closed: {}", session.getRequestURI());
    }




}
