package com.apirest.application.mapper.impl;

import com.apirest.application.dto.ImageDto;
import com.apirest.application.mapper.ImageDtoMapperImage;
import com.apirest.domain.entity.Image;
import com.apirest.domain.entity.Person;
import com.apirest.domain.entity.TypeDocument;
import com.apirest.domain.repository.PersonRepository;
import com.apirest.domain.repository.TypeDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ImageDtoMapperImpl implements ImageDtoMapperImage {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public ImageDto toImageDto(Image image) {
        return ImageDto.builder()
                .id_image(image.get_id())
                .name_image(image.getName())
                .extension_image(image.getExtension())
                .url_image(image.getUrl())
                ._person_image(image.get_person().getId())
                .createdAt_image(image.getCreatedAt())
                .updatedAt_image(image.getUpdatedAt())
                .build();
    }

    @Override
    public Image toImage(ImageDto imageDto) {
        return Image.builder()
                ._id(imageDto.getId_image())
                .name(imageDto.getName_image())
                .extension(imageDto.getExtension_image())
                .url(imageDto.getUrl_image())
                ._person(find_person(imageDto.get_person_image()))
                .createdAt(imageDto.getCreatedAt_image())
                .updatedAt(imageDto.getUpdatedAt_image())
                .build();
    }

    @Override
    public List<ImageDto> listToImageDto(List<Image> image) {
        List<ImageDto> result = new ArrayList<>();
        for (Image img : image) {
            result.add(
                    ImageDto.builder()
                            .id_image(img.get_id())
                            .name_image(img.getName())
                            .extension_image(img.getExtension())
                            .url_image(img.getUrl())
                            ._person_image(img.get_person().getId())
                            .createdAt_image(img.getCreatedAt())
                            .updatedAt_image(img.getUpdatedAt())
                            .build()
            );
        }
        return result;
    }

    @Override
    public Optional<ImageDto> optionalToImageDto(Optional<Image> image_received) {
        Image image = image_received.get();

        return Optional.ofNullable(ImageDto.builder()
                .id_image(image.get_id())
                .name_image(image.getName())
                .extension_image(image.getExtension())
                .url_image(image.getUrl())
                ._person_image(image.get_person().getId())
                .createdAt_image(image.getCreatedAt())
                .updatedAt_image(image.getUpdatedAt())
                .build());

    }

    private Person find_person(String id_person) {
        Person person_search = personRepository.findById(id_person);
        return person_search;
    }
}
