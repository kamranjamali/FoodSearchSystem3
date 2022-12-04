package com.restaurant.Transformer;

import com.restaurant.dto.GalleryDto;
import com.restaurant.entities.GalleryEntity;

import java.util.ArrayList;
import java.util.List;

public class GalleryTransformer {

    public static GalleryEntity getGalleryEntityFromDto(GalleryDto galleryDto){
        GalleryEntity galleryEntity = new GalleryEntity();
        if(galleryDto.getId() != null){
            galleryEntity.setId(Long.parseLong(galleryDto.getId()));
        }
        if(galleryDto.getImageUrl() != null){
            galleryEntity.setImageUrl(galleryDto.getImageUrl());
        }
        if(galleryDto.getRestaurantDto() != null){
            galleryEntity.setRestaurantEntity(RestaurantTransformer.getRestaurantEntityFromDto(galleryDto.getRestaurantDto()));
        }
        return galleryEntity;
    }

    public static GalleryDto getGalleryDtoFromEntity(GalleryEntity galleryEntity){
        GalleryDto galleryDto = new GalleryDto();
        if(galleryEntity.getId() != null){
            galleryDto.setId(galleryEntity.getId().toString());
        }
        if(galleryEntity.getImageUrl() != null){
            galleryDto.setImageUrl(galleryEntity.getImageUrl());
        }
        if(galleryEntity.getRestaurantEntity() != null){
            galleryDto.setRestaurantDto(RestaurantTransformer.getRestaurantDtoFromEntity(galleryEntity.getRestaurantEntity()));
        }
        return galleryDto;
    }

    public static List<GalleryDto> getAllGalleryDtoFromEntities(List<GalleryEntity> galleryEntities){
        List<GalleryDto> galleryDtoList = new ArrayList<>();
        galleryEntities.forEach(galleryEntity->{
            galleryDtoList.add(GalleryTransformer.getGalleryDtoFromEntity(galleryEntity));
        });
        return galleryDtoList;
    }

    public static GalleryEntity updateGallery(GalleryEntity galleryEntity,GalleryDto galleryDto){
        if(galleryDto.getId() != null){
            galleryEntity.setId(Long.parseLong(galleryDto.getId()));
        }
        if(galleryDto.getImageUrl() != null){
            galleryEntity.setImageUrl(galleryDto.getImageUrl());
        }
        if(galleryDto.getRestaurantDto() != null){
            galleryEntity.setRestaurantEntity(RestaurantTransformer.getRestaurantEntityFromDto(galleryDto.getRestaurantDto()));
        }
        return  galleryEntity;
    }


}
