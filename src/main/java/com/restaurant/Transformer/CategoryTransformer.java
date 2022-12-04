package com.restaurant.Transformer;

import com.restaurant.dto.CategoryDto;
import com.restaurant.entities.CategoryEntity;

import java.util.ArrayList;
import java.util.List;

public class CategoryTransformer {

    public static CategoryEntity getEntityFromDto(CategoryDto categoryDto){
        CategoryEntity categoryEntity=new CategoryEntity();

        if(categoryDto.getId() != null){
            categoryEntity.setId(Long.parseLong(categoryDto.getId()));
        }
        if(categoryDto.getTitle() != null){
            categoryEntity.setTitle(categoryDto.getTitle());
        }
        if(categoryDto.getDescription() != null){
            categoryEntity.setDescription(categoryDto.getDescription());
        }
        return categoryEntity;
    }

    public static CategoryDto getDtoFromEntity(CategoryEntity categoryEntity){
        CategoryDto categoryDto=new CategoryDto();
        if(categoryEntity.getId() != null){
            categoryDto.setId(categoryEntity.getId().toString());
        }
        if(categoryEntity.getTitle() != null){
            categoryDto.setTitle(categoryEntity.getTitle());
        }
        if(categoryEntity.getDescription() != null){
            categoryDto.setDescription(categoryEntity.getDescription());
        }
        return categoryDto;
    }

    public static List<CategoryDto> getAllCategories(List<CategoryEntity> categoryEntities){
        List<CategoryDto> categoryDtos=new ArrayList<>();
        categoryEntities.forEach(categoryEntity -> {
            categoryDtos.add(CategoryTransformer.getDtoFromEntity(categoryEntity));
        });
        return categoryDtos;
    }

    public static CategoryEntity updateCategory(CategoryEntity categoryEntity,CategoryDto categoryDto){
        if(categoryDto.getId() !=null){
            categoryEntity.setId(Long.parseLong(categoryDto.getId()));
        }
        if(categoryDto.getTitle() !=null){
            categoryEntity.setTitle(categoryDto.getTitle());
        }
        if(categoryDto.getDescription() !=null){
            categoryEntity.setDescription(categoryDto.getDescription());
        }
        return categoryEntity;
    }
}
