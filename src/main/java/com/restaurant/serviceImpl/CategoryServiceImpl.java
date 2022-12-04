package com.restaurant.serviceImpl;

import com.restaurant.entities.CategoryEntity;
import com.restaurant.repository.CategoryRepository;
import com.restaurant.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public CategoryEntity create(CategoryEntity categoryEntity) {
        return this.categoryRepository.save(categoryEntity);
    }
    @Override
    public CategoryEntity update(CategoryEntity categoryEntity) {
        return this.categoryRepository.save(categoryEntity);
    }

    @Override
    public CategoryEntity findById(Long id) {
        CategoryEntity categoryEntity = this.categoryRepository.findById(id).get();
        return categoryEntity;
    }
    @Override
    public List<CategoryEntity> findAll() {
        List<CategoryEntity> categorylist = this.categoryRepository.findAll();
        return categorylist;
    }
    @Override
    public void deleteAll(List<CategoryEntity> categoryEntityList) {
        categoryEntityList.forEach(categoryEntity ->{
            this.categoryRepository.delete(categoryEntity);
        });
    }
    @Override
    public void delete(CategoryEntity categoryEntity) {
        this.categoryRepository.delete(categoryEntity);
    }
}
