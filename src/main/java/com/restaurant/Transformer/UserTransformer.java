package com.restaurant.Transformer;

import com.restaurant.dto.UserDto;
import com.restaurant.entities.UserEntity;

import java.util.ArrayList;
import java.util.List;

public class UserTransformer {

    //get Dto from Entity
    public static UserDto getUserDtoFromEntity(UserEntity userEntity) {

        UserDto userDto=new UserDto();

        if(userEntity.getId()!=null){
            userDto.setId(userEntity.getId().toString());
        }
        if(userEntity.getName()!=null){
            userDto.setName(userEntity.getName());
        }
        if(userEntity.getEmail()!=null){
         userDto.setEmail(userEntity.getEmail());
        }
        if(userEntity.getPassword()!=null){
            userDto.setPassword(userEntity.getPassword());
        }
        if(userEntity.getCity()!=null){
            userDto.setCity(userEntity.getCity());
        }
        if(userEntity.getCountry()!=null){
            userDto.setCountry(userEntity.getCountry());
        }
        if(userEntity.getAddress_line() != null){
            userDto.setAddress_line(userEntity.getAddress_line());
        }
        return userDto;
    }
    public static UserEntity getUserEntityFromDto(UserDto userDto){
        UserEntity userEntity=new UserEntity();

        if(userDto.getId() != null){
            userEntity.setId(Long.parseLong(userDto.getId()));
        }
        if(userDto.getName() != null){
            userEntity.setName(userDto.getName());
        }
        if(userDto.getEmail() != null){
            userEntity.setEmail(userDto.getEmail());
        }
        if(userDto.getPassword() != null){
            userEntity.setPassword(userDto.getPassword());
        }
        if(userDto.getCity() != null){
            userEntity.setCity(userDto.getCity());
        }
        if(userDto.getCountry() != null){
            userEntity.setCountry(userDto.getCountry());
        }
        if(userDto.getAddress_line() != null){
            userEntity.setAddress_line(userDto.getAddress_line());
        }
        return userEntity;
    }
    public static UserEntity getUserEntityForUpdate(UserEntity userEntity,UserDto userDto){

       if(userDto.getId() != null){
           userEntity.setId(Long.parseLong(userDto.getId()));
       }
       if(userDto.getName() != null){
           userEntity.setName(userDto.getName());
       }
       if(userDto.getEmail() != null){
           userEntity.setEmail(userDto.getEmail());
       }
       if(userDto.getPassword() != null){
           userEntity.setPassword(userDto.getPassword());
       }
       if(userDto.getCity() != null){
           userEntity.setCity(userDto.getCity());
       }
       if(userDto.getCountry() != null){
           userEntity.setCountry(userDto.getCountry());
       }
       if (userDto.getAddress_line() != null){
           userEntity.setAddress_line(userDto.getAddress_line());
       }
       return userEntity;
    }

    //return list of Dtos from Entities
    public  static List<UserDto> getListOfDtoFromEntities(List<UserEntity> userEntities){
        List<UserDto> dtoList = new ArrayList<>();
        userEntities.forEach(userEntity -> {
            dtoList.add(UserTransformer.getUserDtoFromEntity(userEntity));
        });
        return dtoList;
    }

}
