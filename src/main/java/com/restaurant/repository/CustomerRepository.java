package com.restaurant.repository;

import com.restaurant.entities.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public interface CustomerRepository extends JpaRepository<CustomerEntity,Long> {
}
