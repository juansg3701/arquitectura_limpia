package com.apirest.infrastructure.controller;

import com.apirest.application.dto.PersonDto;
import com.apirest.application.service.PersonServiceInterface;
import com.apirest.domain.entity.TypeDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//RestConrtoller para saber que es un controlador rest
@RestController
@RequestMapping("/persons")//-> microsevicio
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.PUT,RequestMethod.POST})
public class PersonRestController {

    @Autowired
    PersonServiceInterface personServiceInterface;


    /* Metodo para todo el listddo de personas al ingresar a /persons *
     */
    @GetMapping()
    public List<PersonDto> findAll() {
        return personServiceInterface.findAll();
    }

    @GetMapping("/{personId}")
    public PersonDto getPerson(@PathVariable String personId) {
        PersonDto person = personServiceInterface.findById(personId);
        return person;
    }

    @PostMapping()
    public PersonDto addPerson(@RequestBody PersonDto person) {
        personServiceInterface.save(person);
        return person;
    }

    @PutMapping()
    public PersonDto updatePerson(@RequestBody PersonDto person) {
        personServiceInterface.update(person);
        return person;
    }

    @DeleteMapping("/{id}")
    public String deletePerson(@PathVariable String id) {
        PersonDto person = personServiceInterface.findById(id);

        if(person == null){
            throw new RuntimeException("Persona no encontrada - " + id);
        }

        personServiceInterface.deleteById(id);
        return "Persona eliminada con id: " + id;
    }
}
