package com.restaurant.serviceImpl;

import com.restaurant.entities.MenuItemEntity;
import com.restaurant.repository.MenuItemRepository;
import com.restaurant.service.MenuItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
public class MenuItemServiceImpl implements MenuItemService {

    @Autowired
    private MenuItemRepository repository;

    @Override
    public MenuItemEntity create(MenuItemEntity menuItem) {
        MenuItemEntity menuItem1 = this.repository.save(menuItem);
        return menuItem1;
    }
    @Override
    public MenuItemEntity update(MenuItemEntity menuItem) {
        return this.repository.save(menuItem);
    }
    @Override
    public MenuItemEntity findById(Long id) {
        MenuItemEntity menuItemEntity = this.repository.findById(id).get();
        return menuItemEntity;
    }
    @Override
    public List<MenuItemEntity> findAll() {
        List<MenuItemEntity> menuItemEntityList = this.repository.findAll();
        return menuItemEntityList;
    }

    @Override
    public void delete(Long id) {
        MenuItemEntity menuItemEntity = this.repository.findById(id).get();
        this.repository.delete(menuItemEntity);
    }

    @Override
    public void deleteAll() {
        List<MenuItemEntity> menuItemEntities = this.repository.findAll();
        menuItemEntities.forEach(menuItemEntity ->{
            this.repository.delete(menuItemEntity);
        });
    }
}
