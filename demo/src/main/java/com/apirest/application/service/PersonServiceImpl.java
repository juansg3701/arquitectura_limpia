package com.apirest.application.service;

import com.apirest.application.dto.PersonDto;
import com.apirest.application.mapper.PersonDtoMapperPerson;
import com.apirest.domain.entity.Person;
import com.apirest.domain.repository.PersonRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonServiceInterface{
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonDtoMapperPerson personDtoMapperPerson;

    @Override
    public List<PersonDto> findAll() {
        return personDtoMapperPerson.listToPersonDto(personRepository.findAll());
    }

    @Override
    public PersonDto findById(String id) {
        return personDtoMapperPerson.toPersonDto(personRepository.findById(id));
    }

    @Override
    public PersonDto save(PersonDto person) {
        PersonDto personDto = new PersonDto();
        System.out.println(personDtoMapperPerson.toPersonDto(personRepository.save(personDtoMapperPerson.toPerson(person))));
        return personDto;
        //return personDtoMapperPerson.toPersonDto(personRepository.save(personDtoMapperPerson.toPerson(person)));
    }

    @Override
    public PersonDto update(PersonDto person) {
        return personDtoMapperPerson.toPersonDto(personRepository.update(personDtoMapperPerson.toPerson(person)));
    }

    @Override
    public boolean deleteById(String id) {
        return personRepository.deleteById(id);
    }
}
