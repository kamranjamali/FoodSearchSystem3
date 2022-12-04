package com.restaurant.repository;

import com.restaurant.entities.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItemEntity,Long> {
}
