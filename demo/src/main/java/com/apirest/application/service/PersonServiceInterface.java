package com.apirest.application.service;

import com.apirest.application.dto.PersonDto;

import java.util.List;

public interface PersonServiceInterface {
    List<PersonDto> findAll();
    PersonDto findById(String id);
    PersonDto save(PersonDto person);
    PersonDto update(PersonDto person);
    boolean deleteById(String id);
}
