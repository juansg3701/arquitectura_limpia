package com.apirest.infrastructure.configuration;

import com.apirest.application.mapper.ImageDtoMapperImage;
import com.apirest.application.mapper.PersonDtoMapperPerson;
import com.apirest.application.mapper.impl.ImageDtoMapperImpl;
import com.apirest.application.mapper.impl.PersonDtoMapperImpl;
import com.apirest.application.service.ImageServiceImpl;
import com.apirest.application.service.PersonServiceImpl;
import com.apirest.domain.repository.ImageRepository;
import com.apirest.domain.repository.PersonRepository;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class BeanConfiguration {

    @Bean
    public ImageDtoMapperImpl imageDtoMapperImpl(){
        return new ImageDtoMapperImpl();
    }

    @Bean
    public PersonDtoMapperImpl personDtoMapperImpl(){
        return new PersonDtoMapperImpl();
    }

}
