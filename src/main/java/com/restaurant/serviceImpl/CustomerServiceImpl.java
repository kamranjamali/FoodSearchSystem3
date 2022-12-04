package com.restaurant.serviceImpl;

import com.restaurant.entities.CustomerEntity;
import com.restaurant.repository.CustomerRepository;
import com.restaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Override
    public CustomerEntity create(CustomerEntity customerEntity) {
        return this.customerRepository.save(customerEntity);
    }
    @Override
    public CustomerEntity update(CustomerEntity customerEntity) {
        CustomerEntity updatedCustomer = this.customerRepository.save(customerEntity);
        return updatedCustomer;
    }
    @Override
    public CustomerEntity findById(Long customerId) {
        CustomerEntity customerEntity = this.customerRepository.findById(customerId).get();
        return customerEntity;
    }
    @Override
    public List<CustomerEntity> findAll() {
        List<CustomerEntity> allCustomers = this.customerRepository.findAll();
        return allCustomers;
    }
    @Override
    public void delete(CustomerEntity customerEntity) {
        this.customerRepository.delete(customerEntity);
    }
}
