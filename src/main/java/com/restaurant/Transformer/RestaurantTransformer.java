package com.restaurant.Transformer;

import com.restaurant.dto.RestaurantDto;
import com.restaurant.dto.UserDto;
import com.restaurant.entities.RestaurantEntity;

import java.util.ArrayList;
import java.util.List;

public class RestaurantTransformer {

    public static RestaurantEntity getRestaurantEntityFromDto(RestaurantDto restaurantDto){

        RestaurantEntity restaurantEntity=new RestaurantEntity();

        if(restaurantDto.getId() != null){
            restaurantEntity.setId(Long.parseLong(restaurantDto.getId()));
        }
        if(restaurantDto.getRestaurantName() != null){
            restaurantEntity.setRestaurant_name(restaurantDto.getRestaurantName());
        }
        if(restaurantDto.getCity() != null){
            restaurantEntity.setCity(restaurantDto.getCity());
        }
        if (restaurantDto.getCountry() != null){
            restaurantEntity.setCountry(restaurantDto.getCountry());
        }
        if(restaurantDto.getEmail() != null){
            restaurantEntity.setEmail(restaurantDto.getEmail());
        }
        if(restaurantDto.getDescription() != null){
            restaurantEntity.setDescription(restaurantDto.getDescription());
        }
        if(restaurantDto.getLatitude() != null){
            restaurantEntity.setLatitude(Double.parseDouble(restaurantDto.getLatitude()));
        }
        if(restaurantDto.getLongitude() != null){
            restaurantEntity.setLongitude(Double.parseDouble(restaurantDto.getLongitude()));
        }
        if(restaurantDto.getWebsiteUrl() != null){
            restaurantEntity.setWebsite_url(restaurantDto.getWebsiteUrl());
        }
        if(restaurantDto.getUserDto() != null){
            restaurantEntity.setUserEntity(UserTransformer.getUserEntityFromDto(restaurantDto.getUserDto()));
        }
        return restaurantEntity;
    }

    public  static  RestaurantDto getRestaurantDtoFromEntity(RestaurantEntity restaurantEntity){

        RestaurantDto restaurantDto=new RestaurantDto();

        if(restaurantEntity.getId() != null){
            restaurantDto.setId(restaurantEntity.getId().toString());
        }
        if(restaurantEntity.getRestaurant_name() != null){
            restaurantDto.setRestaurantName(restaurantEntity.getRestaurant_name());
        }
        if(restaurantEntity.getEmail() != null){
            restaurantDto.setEmail(restaurantEntity.getEmail());
        }
        if(restaurantEntity.getCity() != null){
            restaurantDto.setCity(restaurantEntity.getCity());
        }
        if(restaurantEntity.getCountry() != null){
            restaurantDto.setCountry(restaurantEntity.getCountry());
        }
        if(restaurantEntity.getLongitude() != null){
            restaurantDto.setLongitude(restaurantEntity.getLongitude().toString());
        }
        if(restaurantEntity.getLatitude() != null){
            restaurantDto.setLatitude(restaurantEntity.getLatitude().toString());
        }
        if(restaurantEntity.getDescription() !=null){
            restaurantDto.setDescription(restaurantEntity.getDescription());
        }
        if(restaurantEntity.getWebsite_url() != null){
            restaurantDto.setWebsiteUrl(restaurantEntity.getWebsite_url());
        }
        if(restaurantEntity.getUserEntity() != null){
            restaurantDto.setUserDto(UserTransformer.getUserDtoFromEntity(restaurantEntity.getUserEntity()));
        }
        return restaurantDto;
    }
    public static RestaurantEntity updateRestaurant(RestaurantEntity restaurantEntity,RestaurantDto restaurantDto){

        if(restaurantDto.getId() !=null){
            restaurantEntity.setId(Long.parseLong(restaurantDto.getId()));
        }
        if(restaurantDto.getRestaurantName() != null){
            restaurantEntity.setRestaurant_name(restaurantDto.getRestaurantName());
        }
        if(restaurantDto.getCity() != null){
            restaurantEntity.setCity(restaurantDto.getCity());
        }
        if (restaurantDto.getCountry() != null){
            restaurantEntity.setCountry(restaurantDto.getCountry());
        }
        if(restaurantDto.getEmail() != null){
            restaurantEntity.setEmail(restaurantDto.getEmail());
        }
        if(restaurantDto.getDescription() != null){
            restaurantEntity.setDescription(restaurantDto.getDescription());
        }
        if(restaurantDto.getLatitude() != null){
            restaurantEntity.setLatitude(Double.parseDouble(restaurantDto.getLatitude()));
        }
        if(restaurantDto.getLongitude() != null){
            restaurantEntity.setLongitude(Double.parseDouble(restaurantDto.getLongitude()));
        }
        if(restaurantDto.getWebsiteUrl() != null){
            restaurantEntity.setWebsite_url(restaurantDto.getWebsiteUrl());
        }
        if(restaurantDto.getUserDto().getId() != null){
            restaurantEntity.setUserEntity(UserTransformer.getUserEntityFromDto(restaurantDto.getUserDto()));
        }
        return  restaurantEntity;
    }

    //get list of Restaurant Dto
    public static List<RestaurantDto> getRestaurantDtoListFromEntities(List<RestaurantEntity> entityList) {
        List<RestaurantDto> restaurantDtoList=new ArrayList<>();
        entityList.forEach(restaurantEntity -> {
            restaurantDtoList.add(RestaurantTransformer.getRestaurantDtoFromEntity(restaurantEntity));
        });
        return restaurantDtoList;
    }
}
