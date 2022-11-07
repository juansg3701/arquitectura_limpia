package com.apirest.domain.dao;

import com.apirest.domain.entity.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

//extends MongoRepository<ImageMongo, String>
public interface ImageDAO extends MongoRepository<Image, String>{
    /*
    public List<ImageMongo> findAll();
    public ImageMongo findById(String id);
    public void save(ImageMongo image);
    public void update(String id, ImageMongo image);
    public void delete(String id);

     */
    @Query("_person:?0")
    public List<Image> findAllByPerson(int personId);


    public long count();
}
