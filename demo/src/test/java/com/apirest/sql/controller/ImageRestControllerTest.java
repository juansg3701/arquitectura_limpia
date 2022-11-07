package com.apirest.sql.controller;

import com.apirest.application.dto.ImageDto;
import com.apirest.application.service.ImageServiceInterface;
import com.apirest.infrastructure.controller.ImageController;
import com.apirest.domain.dao.PersonDAO;
import com.apirest.domain.entity.Image;
import com.apirest.domain.entity.Person;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

class ImageRestControllerTest {

    @Mock
    private ImageServiceInterface imageServiceInterface;
    @Mock
    private PersonDAO personDAO;
    @InjectMocks
    private ImageController mongoRestController;

    private ImageDto image;
    private Person person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        person = new Person();
        person.setName("Juan");
        person.setCedula("112323");
        person.setEmail("juan@gmail.com");
        person.setAge(23);
        person.setId("123");

        image = new ImageDto();
        image.setName_image("test");
        image.setId_image("123123");
        image.setExtension_image("jpg");
        image.setUrl_image("http://localhost:8080");
        image.setUpdatedAt_image(new Date());
        image.setCreatedAt_image(new Date());
        image.set_person_image(person.getId());
    }


    @Test
    void getImagesgetImagesMongo() {
        when(imageServiceInterface.findAll()).thenReturn(Arrays.asList(image));
        assertNotNull(mongoRestController.getImagesgetImagesMongo("123"));
    }

    @Test
    void getImage() {
        assertNotNull(mongoRestController.getImage(image.getId_image()));
        assertNotNull(imageServiceInterface.findById(image.getId_image()));
    }

    @Test
    @Disabled
    void addImage() {

        when(imageServiceInterface.save(image)).thenReturn(image);
        MockMultipartFile file = new MockMultipartFile( "file",
                "hello.jpeg",
                String.valueOf(MediaType.IMAGE_JPEG),
                "Hello, World!".getBytes());

        assertNotNull(mongoRestController.addImage(123, file));
    }

    @Test
    void updateImage() {
        when(imageServiceInterface.update(image)).thenReturn(image);
        MockMultipartFile file = new MockMultipartFile( "file",
                "hello.jpeg",
                String.valueOf(MediaType.IMAGE_JPEG),
                "Hello, World!".getBytes());
        System.out.println(mongoRestController.updateImage("123123", file));
        assertNotNull(mongoRestController.updateImage("123123", Mockito.any()));
    }

    @Test
    void deleteImage() {
        assertNotNull(mongoRestController.deleteImage(image.getId_image()));
        // verify(imageMongoDAO,times(1)).deleteById(image.get_id());
        doNothing().doThrow().when(imageServiceInterface).delete(image.getId_image());
    }


}