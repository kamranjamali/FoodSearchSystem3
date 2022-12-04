package com.restaurant.service;

import com.restaurant.entities.ReviewEntity;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public interface ReviewService {


    ReviewEntity create(ReviewEntity reviewEntity);
    ReviewEntity update(ReviewEntity reviewEntity);
    ReviewEntity findById(Long reviewId);
    List<ReviewEntity> findAll();
    void delete(Long reviewId);
    void deleteAll();

}
