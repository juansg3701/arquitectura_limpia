package com.apirest.sql.controller;

import com.apirest.application.dto.PersonDto;
import com.apirest.domain.entity.Person;
import com.apirest.infrastructure.controller.PersonRestController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class PersonRestControllerTest {



    @InjectMocks
    private PersonRestController controller;

    private PersonDto person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        person = new PersonDto();
        person.setName_person("Juan");
        person.setEmail_person("juan@gmail.com");
        //person.setId(123);

    }

    @Test
    void findAll() {
        /*
        when(personDomainServiceInterface.findAll()).thenReturn(Arrays.asList(person));
        List<Person> result= controller.findAll();
        assertEquals(person, result.get(0));
        assertNotNull(controller.findAll());
         */

    }

    @Test
    void getPerson() {
        /*
        when(personDomainServiceInterface.findById(person.getId())).thenReturn(person);
        var result= controller.getPerson(person.getId());
        assertEquals(person, result);
        assertNotNull(controller.getPerson(person.getId()));
         */

    }

    @Test
    void addPerson() {
        /*
        when(personDomainServiceInterface.save(person)).thenReturn(person);
        var result= controller.addPerson(person);
        assertEquals(person, result);
        assertNotNull(controller.addPerson(person));
         */

    }

    @Test
    void updatePerson() {
        /*
        when(personDomainServiceInterface.update(person)).thenReturn(person);
        var result= controller.updatePerson(person);
        assertEquals(person, result);
        assertNotNull(controller.updatePerson(person));
        */

    }

    @Test
    void deletePerson() {
        /*
        System.out.println(personDomainServiceInterface.deleteById(person.getId()));
        when(personDomainServiceInterface.deleteById(person.getId())).thenReturn(true);
        var result = controller.deletePerson(person.getId());
        System.out.println(result);
        * */
        //assertNotNull(controller.deletePerson(result.getId()));
    }
}