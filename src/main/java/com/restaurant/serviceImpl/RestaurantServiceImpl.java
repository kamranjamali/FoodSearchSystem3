package com.restaurant.serviceImpl;

import com.restaurant.entities.RestaurantEntity;
import com.restaurant.repository.RestaurantRepository;
import com.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public RestaurantEntity create(RestaurantEntity restaurantEntity) {
        return this.restaurantRepository.save(restaurantEntity);
    }

    @Override
    public RestaurantEntity update(RestaurantEntity restaurantEntity) {
        RestaurantEntity restaurant = restaurantRepository.save(restaurantEntity);
        return restaurant;
    }
    @Override
    public RestaurantEntity findById(Long id) {
        RestaurantEntity restaurantEntity = restaurantRepository.findById(id).get();
        return restaurantEntity;
    }
    @Override
    public List<RestaurantEntity> findAll() {
        List<RestaurantEntity> restaurantEntities = restaurantRepository.findAll();
        return restaurantEntities;
    }
    @Transactional
    @Override
    public void delete(Long id) {
        RestaurantEntity restaurant = restaurantRepository.findById(id).get();
        restaurantRepository.delete(restaurant);
    }
    @Override
    public void deleteAll(List<RestaurantEntity> restaurantEntities) {
        restaurantEntities.forEach(restaurant -> {
            restaurantRepository.delete(restaurant);
        });
    }
}
