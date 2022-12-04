package com.restaurant.serviceImpl;

import com.restaurant.entities.ReviewEntity;
import com.restaurant.repository.ReviewRepository;
import com.restaurant.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewServiceImpl  implements ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public ReviewEntity create(ReviewEntity reviewEntity) {
        return this.reviewRepository.save(reviewEntity);
    }

    @Override
    public ReviewEntity update(ReviewEntity reviewEntity) {
        return this.reviewRepository.save(reviewEntity);
    }

    @Override
    public ReviewEntity findById(Long reviewId) {
        ReviewEntity reviewEntity = this.reviewRepository.findById(reviewId).get();
        return reviewEntity;
    }

    @Override
    public List<ReviewEntity> findAll() {
        List<ReviewEntity> reviewEntities = this.reviewRepository.findAll();
        return reviewEntities;
    }

    @Override
    public void delete(Long reviewId) {
        ReviewEntity reviewEntity = this.reviewRepository.findById(reviewId).get();
        this.reviewRepository.delete(reviewEntity);
    }

    @Override
    public void deleteAll() {
        List<ReviewEntity> reviewEntities = this.reviewRepository.findAll();
        reviewEntities.forEach(reviewEntity -> {
            this.reviewRepository.delete(reviewEntity);
        });
    }
}
