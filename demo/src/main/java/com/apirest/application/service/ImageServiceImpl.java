package com.apirest.application.service;

import com.apirest.application.dto.ImageDto;
import com.apirest.application.mapper.ImageDtoMapperImage;
import com.apirest.domain.repository.ImageRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageServiceInterface {
    @Autowired
    private ImageRepository imageRepository;
    @Autowired
    private  ImageDtoMapperImage imageDtoMapperImage;

    @Override
    public List<ImageDto> findAll() {
        return imageDtoMapperImage.listToImageDto(imageRepository.findAll());
    }

    @Override
    public Optional<ImageDto> findById(String id) {
        return imageDtoMapperImage.optionalToImageDto(imageRepository.findById(id));
    }

    @Override
    public List<ImageDto> findListByPerson(int id) {
        return imageDtoMapperImage.listToImageDto(imageRepository.findListByPerson(id));
    }

    @Override
    public ImageDto save(ImageDto image) {
        return imageDtoMapperImage.toImageDto(imageRepository.save(imageDtoMapperImage.toImage(image)));
    }

    @Override
    public ImageDto update(ImageDto image) {
        return imageDtoMapperImage.toImageDto(imageRepository.update(imageDtoMapperImage.toImage(image)));
    }

    @Override
    public boolean delete(String id) {
        return imageRepository.delete(id);
    }
}
