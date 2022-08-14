package com.mywebapp.persons.controllers;

import com.mywebapp.persons.domain.Person;
import com.mywebapp.persons.repo.PersonRepo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class PersonRestControllerTest {

    @Autowired
    private PersonRepo personRepo;

    @Autowired
    PersonRestController personRestController;

    @MockBean
    private Pageable pageable;

    @Test
    void testContext(){
        assertThat(personRestController).isNotNull();
    }

    @Test
    void getAll() {
        personRestController.setRepo(personRepo);

        boolean isEmpty = personRestController.getAll(pageable).isEmpty();

        Assert.assertFalse(isEmpty);
    }

    @Test
    void getOne() {

        Person person = new Person((long)1, "ivan", "ivanov", "ivanovich", "1234@mail.com", 12345678);

        Person personDB = personRestController.getOne(person);

        Assert.assertEquals(person, personDB);
    }
}