package com.restaurant.service;

import com.restaurant.entities.CategoryEntity;

import java.util.List;

public interface CategoryService {

    CategoryEntity create(CategoryEntity categoryEntity);
    CategoryEntity update(CategoryEntity categoryEntity);
    CategoryEntity findById(Long id);
    List<CategoryEntity> findAll();
    void deleteAll(List<CategoryEntity> categoryEntityList);
    void delete(CategoryEntity categoryEntity);
}
