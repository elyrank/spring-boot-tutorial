package com.liveperson.tutorial.spring.boot;

import com.liveperson.tutorial.spring.boot.jdbc.PersonRepository;
import com.liveperson.tutorial.spring.boot.jdbc.pojo.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.util.Arrays;

/**
 * @author elyran
 * @since 5/30/16.
 */
@SpringBootApplication
@EnableWebSocket
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

    @Bean
    CommandLineRunner runner(PersonRepository personRepository) {
        return args -> {
            Arrays.asList("Moshe,Danny,Shmulik".split(","))
            .forEach(n -> personRepository.save(new Person(n)));

            //test it:
            personRepository.findAll().forEach(p -> logger.info("person: {}", p));

            personRepository.findPersonByName("Danny")
            .forEach(p -> logger.info("found person by name: {}", p));
        };
    }




    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

}