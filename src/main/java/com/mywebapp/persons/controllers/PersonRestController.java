package com.mywebapp.persons.controllers;

import com.mywebapp.persons.domain.Person;
import com.mywebapp.persons.repo.PersonRepo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/persons")
public class PersonRestController extends AbstractRestController<Person, PersonRepo> {
    public PersonRestController(PersonRepo repo) {
        super(repo);
    }
}
