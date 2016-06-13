package com.liveperson.tutorial.spring.boot.jdbc;

import com.liveperson.tutorial.spring.boot.jdbc.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * @author elyran
 * @since 6/5/16.
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @RequestMapping("/my/persons")
    Collection<Person> getPersons() {
        return personRepository.findAll();
    }

}
