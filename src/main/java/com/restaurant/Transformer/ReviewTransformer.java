package com.restaurant.Transformer;

import com.restaurant.dto.ReviewDto;
import com.restaurant.entities.ReviewEntity;

import java.util.ArrayList;
import java.util.List;

public class ReviewTransformer {

    public static ReviewEntity getReviewEntityFromDto(ReviewDto reviewDto){

        ReviewEntity reviewEntity = new ReviewEntity();
        if(reviewDto.getId()!=null){
            reviewEntity.setReview_id(Long.parseLong(reviewDto.getId()));
        }
        if(reviewDto.getRatings()!=null){
            reviewEntity.setRatings(Long.parseLong(reviewDto.getRatings()));
        }
        if(reviewDto.getComment() != null){
            reviewEntity.setComments(reviewDto.getComment());
        }
        if(reviewDto.getCustomerDto() != null){
            reviewEntity.setCustomersEntity(CustomerTransformer.getCustomerEntityFromDto(reviewDto.getCustomerDto()));
        }
        if(reviewDto.getMenuItemDto() != null){
            reviewEntity.setMenuItemEntity(MenuItemTransformer.getMenuItemEntityFromDto(reviewDto.getMenuItemDto()));
        }
        return reviewEntity;
    }

    public static ReviewDto getReviewDtoFromEntity(ReviewEntity reviewEntity){

        ReviewDto reviewDto = new ReviewDto();
        if(reviewEntity.getReview_id() != null){
            reviewDto.setId(reviewEntity.getReview_id().toString());
        }
        if(reviewEntity.getRatings() != null){
            reviewDto.setRatings(reviewEntity.getRatings().toString());
        }
        if(reviewEntity.getComments() != null){
            reviewDto.setComment(reviewEntity.getComments());
        }
        if(reviewEntity.getCustomersEntity() != null){
            reviewDto.setCustomerDto(CustomerTransformer.getCustomerDtoFromEntity(reviewEntity.getCustomersEntity()));
        }
        if(reviewEntity.getMenuItemEntity() != null){
            reviewDto.setMenuItemDto(MenuItemTransformer.getMenuItemDtoFromEntity(reviewEntity.getMenuItemEntity()));
        }
        return reviewDto;
    }

    public static ReviewEntity updateReviewEntity(ReviewEntity reviewEntity,ReviewDto reviewDto){

        if(reviewDto.getId()!= null){
            reviewEntity.setReview_id(Long.parseLong(reviewDto.getId()));
        }
        if(reviewDto.getRatings()!=null){
            reviewEntity.setRatings(Long.parseLong(reviewDto.getRatings()));
        }
        if(reviewDto.getComment()!=null){
            reviewEntity.setComments(reviewDto.getComment());
        }
        if(reviewDto.getCustomerDto() != null){
            reviewEntity.setCustomersEntity(CustomerTransformer.getCustomerEntityFromDto(reviewDto.getCustomerDto()));
        }
        if(reviewDto.getMenuItemDto() != null){
            reviewEntity.setMenuItemEntity(MenuItemTransformer.getMenuItemEntityFromDto(reviewDto.getMenuItemDto()));
        }
        return reviewEntity;
    }


    public static List<ReviewDto> getAllReviewDto(List<ReviewEntity> reviewEntities){
        List<ReviewDto> reviewDtoList = new ArrayList<>();
        reviewEntities.forEach(reviewEntity ->{
          reviewDtoList.add(ReviewTransformer.getReviewDtoFromEntity(reviewEntity));
        });
        return  reviewDtoList;
    }

}
