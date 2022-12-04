package com.restaurant.service;

import com.restaurant.entities.CustomerEntity;

import java.util.List;

public interface CustomerService {

    CustomerEntity create(CustomerEntity customerEntity);
    CustomerEntity update(CustomerEntity customerEntity);
    CustomerEntity findById(Long customerId);
    List<CustomerEntity> findAll();
    void delete(CustomerEntity customerEntity);

}
