package com.apirest.infrastructure.controller;

import com.apirest.application.dto.ImageDto;
import com.apirest.application.dto.PersonDto;
import com.apirest.application.service.ImageServiceInterface;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/imagesmongo")
public class ImageController {
    @Autowired
    ImageServiceInterface imageServiceInterface;
    @Autowired
    private PersonRestController personRestController;

    @GetMapping()
    public List<ImageDto> getImagesgetImagesMongo(String url) {
       return imageServiceInterface.findAll();
    }

    @GetMapping("/{ImageId}")
    public Optional<ImageDto> getImage(@PathVariable String ImageId) {
        return imageServiceInterface.findById(ImageId);
    }

    @PostMapping("/{PersonaId}")
    public ImageDto addImage(@PathVariable int PersonaId, @RequestParam("file") MultipartFile imagen) {
        ImageDto image = new ImageDto();
        PersonDto informarcion_persona = personRestController.getPerson(Integer.toString(PersonaId) );
        String nombre_hora_unix = Long.toString(System.currentTimeMillis());
        String extension_archivo = FilenameUtils.getExtension(imagen.getOriginalFilename());
        String nombre_imagen = nombre_hora_unix + "." + extension_archivo;
        Timestamp fecha_hora_actual = new Timestamp(System.currentTimeMillis());

        if(informarcion_persona!=null) {
            image.set_person_image(informarcion_persona.getId_person());

            if(!imagen.isEmpty()){
                Path directorioImagenes = Paths.get("demo/src/main/resources/images");
                String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

                try {
                    byte[] byteImg = imagen.getBytes();
                    Path rutaCompleta = Paths.get(rutaAbsoluta+"/"+nombre_imagen);
                    Files.write(rutaCompleta, byteImg);

                    image.setExtension_image(extension_archivo);
                    image.setName_image(nombre_hora_unix);
                    image.setUrl_image(rutaCompleta.toString());
                    image.setCreatedAt_image(fecha_hora_actual);
                    image.setUpdatedAt_image(fecha_hora_actual);
                } catch (IOException e) {
                    throw new RuntimeException("Error al guardar la imagen: " + e.getMessage());
                }
            }
            imageServiceInterface.save(image);
        }
        return image;
    }



    @PutMapping("/{ImageId}")
    public ImageDto updateImage(@PathVariable String ImageId, @RequestParam("file") MultipartFile image){
        ImageDto imagen_encontrada = imageServiceInterface.findById(ImageId).get();

        String extension_archivo = FilenameUtils.getExtension(image.getOriginalFilename());
        String nombre_imagen = imagen_encontrada.getName_image() + "." + extension_archivo;
        Timestamp fecha_hora_actual = new Timestamp(System.currentTimeMillis());

            if(!image.isEmpty()){
                Path directorioImagenes = Paths.get("demo/src/main/resources/images");
                String rutaAbsoluta = directorioImagenes.toFile().getAbsolutePath();

                try {
                    byte[] byteImg = image.getBytes();
                    Path rutaCompleta = Paths.get(rutaAbsoluta+"/"+nombre_imagen);
                    Files.write(rutaCompleta, byteImg);

                    imagen_encontrada.setExtension_image(extension_archivo);
                    imagen_encontrada.setUrl_image(rutaCompleta.toString());
                    imagen_encontrada.setUpdatedAt_image(fecha_hora_actual);
                } catch (IOException e) {
                    throw new RuntimeException("Error al guardar la imagen: " + e.getMessage());
                }
                imageServiceInterface.update(imagen_encontrada);
            }


        return imagen_encontrada;

    }

    @DeleteMapping("/{ImageId}")
    public String deleteImage(@PathVariable String ImageId){
        ImageDto image = imageServiceInterface.findById(ImageId).get();

        if(image ==null){
            throw new RuntimeException("Imagen no encontrada - " + ImageId);
        }

        try{
            Path rutaCompleta = Paths.get("demo/src/main/resources/images");
            Path ruta_eliminar_imagen = Paths.get(rutaCompleta+"/"+ image.getName_image()+"."+ image.getExtension_image());
            Files.delete(ruta_eliminar_imagen);
        }catch (IOException e) {
            throw new RuntimeException("Error al eliminar la imagen: " + e.getMessage());
        }
        imageServiceInterface.delete(ImageId);

        return "Imagen eliminada con id:" + ImageId;
    }
}
