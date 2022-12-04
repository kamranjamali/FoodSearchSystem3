package com.restaurant.Transformer;

import com.restaurant.dto.CustomerDto;
import com.restaurant.entities.CustomerEntity;

import java.util.ArrayList;
import java.util.List;

public class CustomerTransformer {

    public static CustomerEntity getCustomerEntityFromDto(CustomerDto customerDto){
        CustomerEntity customerEntity  = new CustomerEntity();

        if(customerDto.getId() != null){
            customerEntity.setId(Long.parseLong(customerDto.getId()));
        }
        if(customerDto.getFirstName() != null){
            customerEntity.setFirstName(customerDto.getFirstName());
        }
        if(customerDto.getLastName() != null){
            customerEntity.setLastName(customerDto.getLastName());
        }
        if(customerDto.getPhone() != null){
            customerEntity.setPhone(customerDto.getPhone());
        }
        if(customerDto.getEmail() != null){
            customerEntity.setEmail(customerDto.getEmail());
        }
        if(customerDto.getPassword() != null){
            customerEntity.setPassword(customerDto.getPassword());
        }
        if (customerDto.getCity() != null){
            customerEntity.setCity(customerDto.getCity());
        }
        if(customerDto.getCountry() != null){
            customerEntity.setCountry(customerDto.getCountry());
        }
        if(customerDto.getAddressLine() != null){
            customerEntity.setAddressLine(customerDto.getAddressLine());
        }
        return customerEntity;
    }

    public static CustomerDto getCustomerDtoFromEntity(CustomerEntity customerEntity){

        CustomerDto customerDto = new CustomerDto();

        if(customerEntity.getId() != null){
            customerDto.setId(customerEntity.getId().toString());
        }
        if(customerEntity.getFirstName() != null){
            customerDto.setFirstName(customerEntity.getFirstName());
        }
        if(customerEntity.getLastName() != null){
            customerDto.setLastName(customerEntity.getLastName());
        }
        if(customerEntity.getEmail() != null){
            customerDto.setEmail(customerEntity.getEmail());
        }
        if(customerEntity.getPassword() != null){
            customerDto.setPassword(customerEntity.getPassword());
        }
        if(customerEntity.getCity() != null){
            customerDto.setCity(customerEntity.getCity());
        }
        if(customerEntity.getPhone() != null){
            customerDto.setPhone(customerEntity.getPhone());
        }
        if(customerEntity.getCountry() != null){
            customerDto.setCountry(customerEntity.getCountry());
        }
        if(customerEntity.getAddressLine() != null){
            customerDto.setAddressLine(customerEntity.getAddressLine());
        }
        return customerDto;
    }

    public static CustomerEntity getCustomerEntityForUpdate(CustomerEntity customerEntity,CustomerDto customerDto){

        if(customerDto.getId() != null){
            customerEntity.setId(Long.parseLong(customerDto.getId()));
        }
        if(customerDto.getFirstName() != null){
            customerEntity.setFirstName(customerDto.getFirstName());
        }
        if(customerDto.getLastName() != null){
            customerEntity.setLastName(customerDto.getLastName());
        }
        if(customerDto.getEmail() != null){
            customerEntity.setEmail(customerDto.getEmail());
        }
        if(customerDto.getPassword() != null){
            customerEntity.setPassword(customerDto.getPassword());
        }
        if(customerDto.getPhone() != null){
            customerEntity.setPhone(customerDto.getPhone());
        }
        if(customerDto.getCity() != null){
            customerEntity.setCity(customerDto.getCity());
        }
        if(customerDto.getCountry() != null){
            customerEntity.setCountry(customerDto.getCountry());
        }
        if(customerDto.getAddressLine() !=null){
            customerEntity.setAddressLine(customerDto.getAddressLine());
        }
        return customerEntity;
    }

    public static List<CustomerDto> getCustomerDtoListFromEntityList(List<CustomerEntity> customerEntities){
        List<CustomerDto> customerDtoList = new ArrayList<>();
        customerEntities.forEach(entity->{
            customerDtoList.add(CustomerTransformer.getCustomerDtoFromEntity(entity));
        });
        return customerDtoList;
    }
}
