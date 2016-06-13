package com.liveperson.tutorial.spring.boot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author elyran
 * @since 5/30/16.
 */

@RestController
public class HelloController {

    @Value("${rest.message}")
    private String message;

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot! " + message;
    }

}