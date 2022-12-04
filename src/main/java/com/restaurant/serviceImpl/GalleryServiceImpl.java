package com.restaurant.serviceImpl;

import com.restaurant.entities.GalleryEntity;
import com.restaurant.repository.GalleryRepository;
import com.restaurant.service.GalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalleryServiceImpl  implements GalleryService {

    @Autowired
    private GalleryRepository galleryRepository;

    @Override
    public GalleryEntity create(GalleryEntity galleryEntity) {
        return this.galleryRepository.save(galleryEntity);
    }
    @Override
    public GalleryEntity update(GalleryEntity galleryEntity) {
        return this.galleryRepository.save(galleryEntity);
    }
    @Override
    public GalleryEntity findById(Long id) {
        GalleryEntity galleryEntity = this.galleryRepository.findById(id).get();
        return galleryEntity;
    }
    @Override
    public void delete(Long id) {
        GalleryEntity gallery = this.galleryRepository.findById(id).get();
        this.galleryRepository.delete(gallery);
    }
    @Override
    public List<GalleryEntity> findAll() {
        List<GalleryEntity> galleryEntities = this.galleryRepository.findAll();
        return galleryEntities;
    }

    @Override
    public void deleteAll(List<GalleryEntity> galleryEntities) {
        galleryEntities.forEach(galleryEntity ->{
            this.galleryRepository.delete(galleryEntity);
        });
    }
}
