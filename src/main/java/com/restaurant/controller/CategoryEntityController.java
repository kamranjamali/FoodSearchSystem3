package com.restaurant.controller;


import com.restaurant.Transformer.CategoryTransformer;
import com.restaurant.Transformer.RestaurantTransformer;
import com.restaurant.dto.CategoryDto;
import com.restaurant.dto.RestaurantDto;
import com.restaurant.dto.StatusDTO;
import com.restaurant.entities.CategoryEntity;
import com.restaurant.entities.RestaurantEntity;
import com.restaurant.entities.UserEntity;
import com.restaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryEntityController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public ResponseEntity<StatusDTO> create(@ModelAttribute CategoryDto categoryDto) {
        try {
            CategoryEntity categoryEntity = CategoryTransformer.getEntityFromDto(categoryDto);
            categoryEntity = this.categoryService.create(categoryEntity);
            CategoryDto catDto = CategoryTransformer.getDtoFromEntity(categoryEntity);
            return new ResponseEntity(new StatusDTO(1,"Category Added Successfully",catDto),HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @PostMapping("/update")
    public ResponseEntity<StatusDTO> update(@ModelAttribute CategoryDto categoryDto) {
        try {
             CategoryEntity category = this.categoryService.findById(Long.parseLong(categoryDto.getId()));
             if(category==null){
                 return new ResponseEntity(new StatusDTO(0,"This Category does not exist"),HttpStatus.NOT_FOUND);
             }
             CategoryEntity updatedCategory = CategoryTransformer.updateCategory(category, categoryDto);
             updatedCategory = this.categoryService.update(updatedCategory);
            CategoryDto catDto2 = CategoryTransformer.getDtoFromEntity(updatedCategory);
            return new ResponseEntity(new StatusDTO(1,"Category Updated Successfully",catDto2),HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> findById(@PathVariable("id") Long id) {
        try {
            CategoryEntity category = categoryService.findById(id);
            if(category==null){
            return new ResponseEntity(new StatusDTO(1,"Category Not Found With this Id"),HttpStatus.NOT_FOUND);
            }
            CategoryDto categoryDto = CategoryTransformer.getDtoFromEntity(category);
            return new ResponseEntity(categoryDto,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }
    @GetMapping("/find-all")
    public ResponseEntity<StatusDTO> findAll() {
        try {
            List<CategoryEntity> categoryEntities = this.categoryService.findAll();
            List<CategoryDto> categoryDtos = CategoryTransformer.getAllCategories(categoryEntities);
            return new ResponseEntity(categoryDtos,HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<StatusDTO> delete(@PathVariable("id") Long id) {
        try {
            CategoryEntity category = this.categoryService.findById(id);
            if(category==null){
                return new ResponseEntity(new StatusDTO(0,"Category Not Exist with this id"),HttpStatus.NOT_FOUND);
            }
            categoryService.delete(category);
            return new ResponseEntity(new StatusDTO( 1,"Category Deleted successfully"),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<StatusDTO> deleteAll() {
        try {
            List<CategoryEntity> categoryEntities = this.categoryService.findAll();
            this.categoryService.deleteAll(categoryEntities);
            return new ResponseEntity(new StatusDTO( 1,"All Category Deleted successfully"),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }




}
