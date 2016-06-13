package com.liveperson.tutorial.spring.boot.jdbc;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author elyran
 * @since 6/5/16.
 */


@Entity
public class Person {
    private String name;

    @Id
    @GeneratedValue
    private Long id;

    public Person() {
    }

    public Person(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
