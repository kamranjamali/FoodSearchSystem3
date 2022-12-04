package com.restaurant.service;

import com.restaurant.entities.RestaurantEntity;

import java.util.List;

public interface RestaurantService {

    RestaurantEntity create(RestaurantEntity restaurantEntity);

    RestaurantEntity update(RestaurantEntity restaurantEntity);

    RestaurantEntity findById(Long id);

    List<RestaurantEntity> findAll();

    void deleteAll (List<RestaurantEntity> restaurantEntities);

    void delete(Long id);
}
