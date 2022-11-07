package com.apirest.application.dto;

import com.apirest.domain.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ImageDto {
    private String id_image;
    private String name_image;
    private String extension_image;
    private String url_image;
    private Date createdAt_image;
    private Date updatedAt_image;
    private String _person_image;

    public ImageDto clone(){
        return ImageDto.builder()
                .id_image(id_image)
                .name_image(name_image)
                .extension_image(extension_image)
                .url_image(url_image)
                .createdAt_image(createdAt_image)
                .updatedAt_image(updatedAt_image)
                ._person_image(_person_image)
                .build();
    }
}
