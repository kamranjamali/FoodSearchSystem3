package com.restaurant.service;

import com.restaurant.entities.MenuItemEntity;

import java.util.List;

public interface MenuItemService {

    MenuItemEntity create(MenuItemEntity menuItem);
    MenuItemEntity update(MenuItemEntity menuItem);
    MenuItemEntity findById(Long id);
    List<MenuItemEntity> findAll();
    void delete(Long id);
    void deleteAll();
}
