package com.restaurant.repository;

import com.restaurant.entities.GalleryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<GalleryEntity,Long> {
}
