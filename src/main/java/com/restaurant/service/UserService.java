package com.restaurant.service;

import com.restaurant.entities.UserEntity;

import java.util.List;

public interface UserService {

    UserEntity createUser(UserEntity user);
    UserEntity updateUser(UserEntity user);
    UserEntity findById(Long userId);
    List<UserEntity> findAll();
    void delete(UserEntity userEntity);



}
