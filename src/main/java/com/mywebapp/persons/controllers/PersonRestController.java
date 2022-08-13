package com.mywebapp.persons.controllers;

import com.mywebapp.persons.config.SwaggerConfig;
import com.mywebapp.persons.domain.Person;
import com.mywebapp.persons.repo.PersonRepo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = SwaggerConfig.TAG_PERSONS_REST_CONTROLLER)
@RequestMapping("/api/persons")
public class PersonRestController extends AbstractRestController<Person, PersonRepo> {
    public PersonRestController(PersonRepo repo) {
        super(repo);
    }
}
