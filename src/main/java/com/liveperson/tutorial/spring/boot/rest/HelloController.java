package com.liveperson.tutorial.spring.boot.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author elyran
 * @since 5/30/16.
 */

@RestController
public class HelloController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot! ";
    }

}