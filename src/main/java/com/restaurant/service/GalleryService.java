package com.restaurant.service;

import com.restaurant.entities.GalleryEntity;

import java.util.List;

public interface GalleryService {


    GalleryEntity create(GalleryEntity galleryEntity);
    GalleryEntity update(GalleryEntity galleryEntity);
    GalleryEntity findById(Long id);
    void delete(Long id);
    List<GalleryEntity> findAll();
    void deleteAll(List<GalleryEntity> galleryEntities);
}
