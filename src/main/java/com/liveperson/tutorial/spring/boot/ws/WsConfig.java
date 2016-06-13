package com.liveperson.tutorial.spring.boot.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * @author elyran
 * @since 6/13/16.
 */
@Configuration
@EnableWebSocket
public class WsConfig implements WebSocketConfigurer {


    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(wsHandler(), "/ws").setAllowedOrigins("*");
    }

    @Bean
    public WsHandler wsHandler() {
        return new WsHandler();
    }



}
