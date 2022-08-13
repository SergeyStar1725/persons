package com.mywebapp.persons.controllers;

import com.mywebapp.persons.repo.PersonRepo;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonRestControllerTest {

    @MockBean
    private PersonRepo personRepo;

    @MockBean
    private Pageable pageable;

    @Test
    void getAll() {
        PersonRestController personRestController = new PersonRestController(personRepo);
        boolean isEmpty = personRestController.getAll(pageable).isEmpty();

        Assert.assertTrue(isEmpty);
    }
}