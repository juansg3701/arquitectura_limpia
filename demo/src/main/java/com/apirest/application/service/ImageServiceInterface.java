package com.apirest.application.service;

import com.apirest.application.dto.ImageDto;
import com.apirest.domain.entity.Image;

import java.util.List;
import java.util.Optional;

public interface ImageServiceInterface {
    List<ImageDto> findAll();
    Optional<ImageDto> findById(String id);
    List<ImageDto> findListByPerson(int id);
    ImageDto save(ImageDto image);
    ImageDto update(ImageDto image);
    boolean delete(String id);
}
