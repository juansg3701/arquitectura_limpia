package com.apirest.sql.service.imagemongo;

import com.apirest.domain.dao.ImageDAO;
import com.apirest.domain.entity.Image;
import com.apirest.domain.entity.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ImageServiceImplTest {
/*
    @Mock
    private ImageDAO imageDAO;

    @InjectMocks
    private ImageDomainServiceImpl imageMongoService;

    private Image image;
    private Person person;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        person = new Person();
        person.setName("Juan");
        person.setEmail("juan@gmail.com");
        person.setId(123);

        image = new Image();
        image.setName("test");
        image.set_id("123123");
        image.setExtension("jpg");
        image.setUrl("http://localhost:8080");
        image.setUpdatedAt(new Date());
        image.setCreatedAt(new Date());
        image.set_person(person);


    }

    @Test
    void findAll() {
        when(imageDAO.findAll()).thenReturn(Arrays.asList(image));
        assertNotNull(imageMongoService.findAll());
    }

    @Test
    void findById() {

        ImageMongoDAO imageMongoDAO = mock(ImageMongoDAO.class);
        assertNotNull(imageMongoService.findById(image.get_id()));
        verify(imageMongoDAO,times(1)).findById(image.get_id());

        assertNotNull(imageMongoService.findById(image.get_id()));
        assertNotNull(imageDAO.findById(image.get_id()));
    }

    @Test
    void findListByPerson() {
        when(imageDAO.findAllByPerson(person.getId())).thenReturn(Arrays.asList(image));
        assertNotNull(imageMongoService.findListByPerson(person.getId()));
    }

    @Test
    void save() {
        when(imageDAO.save(image)).thenReturn(image);
        assertNotNull(imageMongoService.save(image));
    }

    @Test
    void update() {
        //when(imageMongoDAO.update()).thenReturn(Arrays.asList(image));
        when(imageMongoService.update(image)).thenReturn(image);
       // assertNotNull(imageMongoService.update(image));
    }

    @Test
    void delete() {
        //ImageMongoDAO imageMongoDAO = mock(ImageMongoDAO.class);
        assertNotNull(imageMongoService.delete(image.get_id()));
       // verify(imageMongoDAO,times(1)).deleteById(image.get_id());
        doNothing().doThrow().when(imageDAO).deleteById(image.get_id());
        //when(imageMongoDAO.deleteById(image.get_id())).thenReturn(image);
    }
    */
}