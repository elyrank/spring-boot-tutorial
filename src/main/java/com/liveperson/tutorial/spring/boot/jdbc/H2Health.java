package com.liveperson.tutorial.spring.boot.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author elyran
 * @since 6/5/16.
 */
@Component
public class H2Health implements HealthIndicator {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Health health() {
        final List<Person> all = personRepository.findAll();
        if (all.isEmpty()) {
            return Health.down().withDetail("reason","data is empty").build();
        }
        return Health.up().withDetail("data",all).build();
    }
}
