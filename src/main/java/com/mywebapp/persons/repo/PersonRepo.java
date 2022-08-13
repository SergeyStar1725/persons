package com.mywebapp.persons.repo;

import com.mywebapp.persons.domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepo extends JpaRepository<Person, Long> {
}
