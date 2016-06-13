package com.liveperson.tutorial.spring.boot.jdbc;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

/**
 * @author elyran
 * @since 6/5/16.
 */
@RepositoryRestResource
public interface PersonRepository extends JpaRepository<Person, Long> {

    Collection<Person> findPersonByName(@Param("name") String name);
}
