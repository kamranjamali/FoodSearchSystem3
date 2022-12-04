package com.restaurant.controller;

import com.restaurant.Transformer.CategoryTransformer;
import com.restaurant.Transformer.ReviewTransformer;
import com.restaurant.dto.CategoryDto;
import com.restaurant.dto.ReviewDto;
import com.restaurant.dto.StatusDTO;
import com.restaurant.entities.CategoryEntity;
import com.restaurant.entities.CustomerEntity;
import com.restaurant.entities.MenuItemEntity;
import com.restaurant.entities.ReviewEntity;
import com.restaurant.service.CustomerService;
import com.restaurant.service.MenuItemService;
import com.restaurant.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewEntityController {

    @Autowired
    private ReviewService reviewService;
    @Autowired
    private CustomerService customerService;
    @Autowired
    private MenuItemService menuItemService;

    @PostMapping("/create")
    public ResponseEntity<StatusDTO> create(@ModelAttribute ReviewDto reviewDto) {
        try {
            CustomerEntity customerEntity = this.customerService.findById(Long.parseLong(reviewDto.getCustomerDto().getId()));
            if(customerEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Customer Id Not Found with this Id"),HttpStatus.NOT_FOUND);
            }
            MenuItemEntity menuItemEntity = this.menuItemService.findById(Long.parseLong(reviewDto.getMenuItemDto().getId()));
            if(menuItemEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Menu Item Id not found with this Id"),HttpStatus.NOT_FOUND);
            }
            ReviewEntity reviewEntity = ReviewTransformer.getReviewEntityFromDto(reviewDto);
            reviewEntity = this.reviewService.create(reviewEntity);
            ReviewDto reviewDto1 = ReviewTransformer.getReviewDtoFromEntity(reviewEntity);
            return new ResponseEntity(new StatusDTO(1,"Review Added Successfully",reviewDto1), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<StatusDTO> update(@ModelAttribute ReviewDto reviewDto) {
        try {
            ReviewEntity reviewEntity = this.reviewService.findById(Long.parseLong(reviewDto.getId()));
            if(reviewEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Review Not Found With this Id "),HttpStatus.NOT_FOUND);
            }
            CustomerEntity customerEntity = this.customerService.findById(Long.parseLong(reviewDto.getCustomerDto().getId()));
            if(customerEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Customer Id Not Found with this Id"),HttpStatus.NOT_FOUND);
            }
            MenuItemEntity menuItemEntity = this.menuItemService.findById(Long.parseLong(reviewDto.getMenuItemDto().getId()));
            if(menuItemEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Menu Item Id not found with this Id"),HttpStatus.NOT_FOUND);
            }
            ReviewEntity updateReviewEntity = ReviewTransformer.updateReviewEntity(reviewEntity, reviewDto);
            updateReviewEntity = this.reviewService.update(updateReviewEntity);
            ReviewDto reviewDto1 = ReviewTransformer.getReviewDtoFromEntity(updateReviewEntity);
            return new ResponseEntity(new StatusDTO(1,"Review Updated Successfully",reviewDto1), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<StatusDTO> findById(@PathVariable Long reviewId) {
        try {
            ReviewEntity reviewEntity = this.reviewService.findById(reviewId);
            if(reviewEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Review Id Not Exists"),HttpStatus.NOT_FOUND);
            }
            ReviewDto reviewDto = ReviewTransformer.getReviewDtoFromEntity(reviewEntity);
            return new ResponseEntity(reviewDto,HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @GetMapping("/find-all")
    public ResponseEntity<StatusDTO> findAll() {
        try {
            List<ReviewEntity> reviewEntities = this.reviewService.findAll();
            List<ReviewDto> reviewDtoList = ReviewTransformer.getAllReviewDto(reviewEntities);
            return new ResponseEntity(reviewDtoList,HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<StatusDTO> delete(@PathVariable Long reviewId) {
        try {
            ReviewEntity reviewEntity = this.reviewService.findById(reviewId);
            if(reviewEntity==null){
                return new ResponseEntity(new StatusDTO(0,"this Review Id Not Exists"),HttpStatus.NOT_FOUND);
            }
            this.reviewService.delete(reviewId);
            return new ResponseEntity(new StatusDTO(1,"Review Deleted Successfully"), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<StatusDTO> deleteAll() {
        try {
            this.reviewService.deleteAll();
            return new ResponseEntity(new StatusDTO(1,"Review Deleted Successfully"), HttpStatus.OK);
        }catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }




}
