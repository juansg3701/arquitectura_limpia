package com.apirest.domain.repository;

import com.apirest.domain.entity.Image;
import com.apirest.domain.dao.ImageDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class ImageRepositoryImpl implements ImageRepository {
    @Autowired
    private final ImageDAO imageDao;

    @Override
    public List<Image> findAll() {
        List<Image> array_imprimir = new ArrayList<>();
        imageDao.findAll().forEach(item -> array_imprimir.add(item));
        return array_imprimir;
    }

    @Override
    public Optional<Image> findById(String id) {
        Optional<Image> image_imprimir =  imageDao.findById(id);
        if(image_imprimir==null){
            throw new NoSuchElementException();
        }
        return image_imprimir;
    }

    @Override
    public List<Image> findListByPerson(int personId) {
        return imageDao.findAllByPerson(personId);
    }

    @Override
    public Image save(Image image) {
        return imageDao.save(image);
    }

    @Override
    public Image update(Image image) {
        return imageDao.save(image);
    }

    @Override
    public boolean delete(String id) {
        try {
            imageDao.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
