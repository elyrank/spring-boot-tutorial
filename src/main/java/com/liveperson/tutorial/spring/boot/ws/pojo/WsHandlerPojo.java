package com.liveperson.tutorial.spring.boot.ws.pojo;

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
@ServerEndpoint(value = "/pojo", encoders = Greeting.Coder.class, decoders = HelloMessage.Coder.class)
public class WsHandlerPojo {

    private static final Logger logger = LoggerFactory.getLogger(WsHandlerPojo.class);

    @OnMessage
    public Greeting echoMessage(HelloMessage message)  {
        logger.info("received message: {}", message);
        return new Greeting(message.getName());
    }

    @OnOpen
    public void open(Session session) throws Exception {
        logger.info("session opened: {}", session.getRequestURI());
        if (false) {
            session.close(new CloseReason(() -> 4401, "test 4401 code"));
        }
    }




}
