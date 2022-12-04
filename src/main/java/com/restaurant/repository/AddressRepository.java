package com.restaurant.repository;

import com.restaurant.entities.AdressEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AdressEntity,Long> {
}
