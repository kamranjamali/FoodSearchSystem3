package com.restaurant.controller;

import com.restaurant.Transformer.CategoryTransformer;
import com.restaurant.Transformer.GalleryTransformer;
import com.restaurant.dto.CategoryDto;
import com.restaurant.dto.GalleryDto;
import com.restaurant.dto.StatusDTO;
import com.restaurant.entities.CategoryEntity;
import com.restaurant.entities.GalleryEntity;
import com.restaurant.entities.RestaurantEntity;
import com.restaurant.service.GalleryService;
import com.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gallery")
public class GalleryEntityController {


    @Autowired
    private GalleryService galleryService;

    @Autowired
    private RestaurantService restaurantService;

    @PostMapping("/create")
    public ResponseEntity<StatusDTO> create(@ModelAttribute GalleryDto galleryDto) {
        try {
            RestaurantEntity restaurant = this.restaurantService.findById(Long.parseLong(galleryDto.getRestaurantDto().getId()));
            if(restaurant==null){
                return new ResponseEntity(new StatusDTO(0,"Restaurant Id Not Found "),HttpStatus.NOT_FOUND);
            }
            GalleryEntity galleryEntity = GalleryTransformer.getGalleryEntityFromDto(galleryDto);
            galleryEntity=this.galleryService.create(galleryEntity);
            GalleryDto galleryDto1 = GalleryTransformer.getGalleryDtoFromEntity(galleryEntity);
            return new ResponseEntity(new StatusDTO(1,"Gallery Added Successfully",galleryDto1), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<StatusDTO> update(@ModelAttribute GalleryDto galleryDto) {
        try {
            GalleryEntity gallery = this.galleryService.findById(Long.parseLong(galleryDto.getId()));
            if(gallery==null){
                return new ResponseEntity(new StatusDTO(0,"this Gallery Id Not Found "),HttpStatus.NOT_FOUND);
            }
            RestaurantEntity restaurant = this.restaurantService.findById(Long.parseLong(galleryDto.getRestaurantDto().getId()));
            if(restaurant==null){
                return new ResponseEntity(new StatusDTO(0,"Restaurant Id Not Found "),HttpStatus.NOT_FOUND);
            }
            GalleryEntity updateGallery = GalleryTransformer.updateGallery(gallery, galleryDto);
            updateGallery=this.galleryService.update(updateGallery);
            GalleryDto galleryDto1 = GalleryTransformer.getGalleryDtoFromEntity(updateGallery);
            return new ResponseEntity(new StatusDTO(1,"Gallery Updated Successfully",galleryDto1), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @GetMapping("/{galleryId}")
    public ResponseEntity<StatusDTO> findById(@PathVariable Long galleryId) {
        try {
            GalleryEntity gallery = this.galleryService.findById(galleryId);
            if(gallery==null){
                return new ResponseEntity(new StatusDTO(0,"this Gallery Id Not Found "),HttpStatus.NOT_FOUND);
            }
            GalleryDto galleryDto = GalleryTransformer.getGalleryDtoFromEntity(gallery);
            return new ResponseEntity(galleryDto,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<StatusDTO> findAll() {
        try {
            List<GalleryEntity> galleryEntities = this.galleryService.findAll();
            List<GalleryDto> galleryDtoList = GalleryTransformer.getAllGalleryDtoFromEntities(galleryEntities);
            return new ResponseEntity(galleryDtoList,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/{galleryId}")
    public ResponseEntity<StatusDTO> delete(@PathVariable Long galleryId ) {
        try {
            GalleryEntity galleryEntity = this.galleryService.findById(galleryId);
            if(galleryEntity==null){
                return new ResponseEntity(new StatusDTO(0,"this Gallery Id Not Found "),HttpStatus.NOT_FOUND);
            }
            this.galleryService.delete(galleryId);
            return new ResponseEntity(new StatusDTO(1,"Gallery Deleted Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/delete-all")
    public ResponseEntity<StatusDTO> deleteAll( ) {
        try {
            List<GalleryEntity> galleryEntities = this.galleryService.findAll();
            this.galleryService.deleteAll(galleryEntities);
            return new ResponseEntity(new StatusDTO(1,"All Gallery Deleted Successfully"), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }




}
