package com.restaurant.Transformer;

import com.restaurant.dto.MenuItemDto;
import com.restaurant.entities.MenuItemEntity;

import java.util.ArrayList;
import java.util.List;

public class MenuItemTransformer {

    public static MenuItemEntity getMenuItemEntityFromDto(MenuItemDto menuItemDto){
        MenuItemEntity menuItemEntity=new MenuItemEntity();
        if(menuItemDto.getId() != null){
            menuItemEntity.setId(Long.parseLong(menuItemDto.getId()));
        }
        if(menuItemDto.getName() != null){
            menuItemEntity.setName(menuItemDto.getName());
        }
        if(menuItemDto.getPrice() != null){
            menuItemEntity.setPrice(Double.parseDouble(menuItemDto.getPrice()));
        }
        if(menuItemDto.getDiscount() != null){
            menuItemEntity.setDiscount(Double.parseDouble(menuItemDto.getDiscount()));
        }
        if(menuItemDto.getImage() != null){
            menuItemEntity.setImage(menuItemDto.getImage());
        }
        if(menuItemDto.getCategoryDto() != null){
            menuItemEntity.setCategoryEntity(CategoryTransformer.getEntityFromDto(menuItemDto.getCategoryDto()));
        }
        if(menuItemDto.getRestaurantDto() != null){
            menuItemEntity.setRestaurantEntity(RestaurantTransformer.getRestaurantEntityFromDto(menuItemDto.getRestaurantDto()));
        }
        return  menuItemEntity;
    }
    public static MenuItemDto getMenuItemDtoFromEntity(MenuItemEntity menuItemEntity){
        MenuItemDto menuItemDto=new MenuItemDto();

        if(menuItemEntity.getId() !=null){
            menuItemDto.setId(menuItemEntity.getId().toString());
        }
        if(menuItemEntity.getName() !=null){
            menuItemDto.setName(menuItemEntity.getName());
        }
        if(menuItemEntity.getPrice() !=null){
            menuItemDto.setPrice(menuItemEntity.getPrice().toString());
        }
        if(menuItemEntity.getDiscount() !=null){
            menuItemDto.setDiscount(menuItemEntity.getDiscount().toString());
        }
        if(menuItemEntity.getImage() !=null){
            menuItemDto.setImage(menuItemEntity.getImage());
        }
        if(menuItemEntity.getCategoryEntity() !=null){
            menuItemDto.setCategoryDto(CategoryTransformer.getDtoFromEntity(menuItemEntity.getCategoryEntity()));
        }
        if(menuItemEntity.getRestaurantEntity() != null){
            menuItemDto.setRestaurantDto(RestaurantTransformer.getRestaurantDtoFromEntity(menuItemEntity.getRestaurantEntity()));
        }
        return menuItemDto;
    }


    public static MenuItemEntity updateMenuItemEntity(MenuItemEntity menuItemEntity,MenuItemDto menuItemDto){

        if(menuItemDto.getId() != null){
            menuItemEntity.setId(Long.parseLong(menuItemDto.getId()));
        }
        if(menuItemDto.getName() != null){
            menuItemEntity.setName(menuItemDto.getName());
        }
        if(menuItemDto.getPrice() != null){
            menuItemEntity.setPrice(Double.parseDouble(menuItemDto.getPrice()));
        }
        if(menuItemDto.getDiscount() != null){
            menuItemEntity.setDiscount(Double.parseDouble(menuItemDto.getDiscount()));
        }
        if(menuItemDto.getImage() != null){
            menuItemEntity.setImage(menuItemDto.getImage());
        }
        if(menuItemDto.getCategoryDto() != null){
            menuItemEntity.setCategoryEntity(CategoryTransformer.getEntityFromDto(menuItemDto.getCategoryDto()));
        }
        if(menuItemDto.getRestaurantDto() != null){
            menuItemEntity.setRestaurantEntity(RestaurantTransformer.getRestaurantEntityFromDto(menuItemDto.getRestaurantDto()));
        }
        return menuItemEntity;
    }

    public static List<MenuItemDto> getAllMenuItemDtos(List<MenuItemEntity> menuItemEntities){
        List<MenuItemDto> menuItemDtoList = new ArrayList<>();
        menuItemEntities.forEach(menuItemEntity->{
            menuItemDtoList.add(MenuItemTransformer.getMenuItemDtoFromEntity(menuItemEntity));
        });
        return menuItemDtoList;
    }

}
