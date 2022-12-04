package com.restaurant.controller;

import com.restaurant.Transformer.CustomerTransformer;
import com.restaurant.dto.CustomerDto;
import com.restaurant.dto.StatusDTO;

import com.restaurant.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerEntityController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<StatusDTO> createCustomer(@ModelAttribute CustomerDto customerDto) {
        try {
            CustomerEntity customerEntity = CustomerTransformer.getCustomerEntityFromDto(customerDto);
            customerEntity = this.customerService.create(customerEntity);
            CustomerDto customerDto1 = CustomerTransformer.getCustomerDtoFromEntity(customerEntity);
            return new ResponseEntity(new StatusDTO(1, "Customer Created Successfully", customerDto1), HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "), HttpStatus.OK);
        }
    }
    @PostMapping("/update")
    public ResponseEntity<StatusDTO> updateCustomer(@ModelAttribute CustomerDto customerDto) {
        try {
            CustomerEntity customerEntity = this.customerService.findById(Long.parseLong(customerDto.getId()));
            if (customerEntity == null) {
                return new ResponseEntity(new StatusDTO(0, "this customer id not found"), HttpStatus.NOT_FOUND);
            } else {
                CustomerEntity updatedCustomer = CustomerTransformer.getCustomerEntityForUpdate(customerEntity, customerDto);
                CustomerEntity customerEntity1 = this.customerService.create(updatedCustomer);
                CustomerDto updatedDto = CustomerTransformer.getCustomerDtoFromEntity(customerEntity1);
                return new ResponseEntity(new StatusDTO(1, "Customer Updated Successfully", updatedDto), HttpStatus.OK);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "), HttpStatus.OK);
        }
    }
    @GetMapping("/get/{customerId}")
    public ResponseEntity<StatusDTO> findById(@PathVariable Long customerId) {
        try {
            CustomerEntity customerEntity = this.customerService.findById(customerId);
            if (customerEntity != null) {
                CustomerDto customerDto = CustomerTransformer.getCustomerDtoFromEntity(customerEntity);
                return new ResponseEntity(customerDto, HttpStatus.OK);
            } else {
                return new ResponseEntity(new StatusDTO(0, "Customer Not Found With this Id"), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "), HttpStatus.OK);
        }
    }

    @GetMapping("/get-all")
    public List<CustomerDto> findAll() throws Exception {
        List<CustomerEntity> customerEntities = this.customerService.findAll();
        List<CustomerDto> allCustomerDtos = CustomerTransformer.getCustomerDtoListFromEntityList(customerEntities);
        return allCustomerDtos;
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<StatusDTO> delete(@PathVariable  Long customerId){
        try {
            CustomerEntity customerEntity = this.customerService.findById(customerId);
            if(customerEntity != null) {
                this.customerService.delete(customerEntity);
                return new ResponseEntity(new StatusDTO(1,"Customer Deleted Succesfully"),HttpStatus.OK);
            }else {
                return new ResponseEntity(new StatusDTO(0,"Customer Not Found with this Id"),HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured "),HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<StatusDTO> deleteAll() throws Exception{
        try {
            List<CustomerEntity> customerEntities = this.customerService.findAll();
            for (CustomerEntity entity:customerEntities){
                this.customerService.delete(entity);
            }
            return new ResponseEntity(new StatusDTO( 1,"All Deleted Sucessfully"),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO( 1,"Exception Accured !!"),HttpStatus.OK);
        }
    }

}
