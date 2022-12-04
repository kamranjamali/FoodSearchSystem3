package com.restaurant.controller;

import com.restaurant.Transformer.UserTransformer;
import com.restaurant.dto.StatusDTO;
import com.restaurant.dto.UserDto;
import com.restaurant.entities.UserEntity;
import com.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEntityController {
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<StatusDTO> createUser(@ModelAttribute UserDto userDto){
        try {
            UserEntity userEntity = UserTransformer.getUserEntityFromDto(userDto);
            userEntity=this.userService.createUser(userEntity);
            UserDto userDto2 = UserTransformer.getUserDtoFromEntity(userEntity);
            return new ResponseEntity(new StatusDTO(1,"User Created Succesfully ",userDto2), HttpStatus.CREATED);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured "),HttpStatus.OK);
        }
    }
    @PutMapping("/update")
    public ResponseEntity<StatusDTO> updateUser(@ModelAttribute UserDto userDto){
        try {
            UserEntity userEntity = this.userService.findById(Long.parseLong(userDto.getId()));
            if(userEntity == null){
                return new ResponseEntity(new StatusDTO(0,"User Entity not found "),HttpStatus.NOT_FOUND);
            }else {
                UserEntity updatedEntity = UserTransformer.getUserEntityForUpdate(userEntity, userDto);
                UserEntity user = this.userService.createUser(updatedEntity);
                return new ResponseEntity(new StatusDTO(1, "User Updated Succesfully", UserTransformer.getUserDtoFromEntity(user)), HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured "),HttpStatus.OK);
        }
    }
    @GetMapping("/get/{userId}")
    public ResponseEntity<StatusDTO> findById(@PathVariable("userId") Long userId) throws Exception{
        try {
            UserEntity userEntity = this.userService.findById(userId);
            if(userEntity !=null){
                UserDto userDto = UserTransformer.getUserDtoFromEntity(userEntity);
                return new ResponseEntity(userDto,HttpStatus.OK);
            }else {
                return new ResponseEntity(new StatusDTO(0,"User Not Found With this Id"),HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured "),HttpStatus.OK);
        }
    }
    @GetMapping("/get-all")
    public List<UserDto> findAll() throws Exception{
        List<UserEntity> userEntities = this.userService.findAll();
        List<UserDto> listOfUserDtos = UserTransformer.getListOfDtoFromEntities(userEntities);
        return listOfUserDtos;
    }
    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<StatusDTO> delete(@PathVariable  Long userId){
        try {
            UserEntity userEntity = this.userService.findById(userId);
            if(userEntity != null) {
                this.userService.delete(userEntity);
                return new ResponseEntity(new StatusDTO(1,"User Deleted Succesfully"),HttpStatus.OK);
            }else {
                return new ResponseEntity(new StatusDTO(0,"User Not Found with this Id"),HttpStatus.NOT_FOUND);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured "),HttpStatus.OK);
        }
    }
    @DeleteMapping("/delete-all")
    public ResponseEntity<StatusDTO> deleteAll() throws Exception{
        try {
            List<UserEntity> entityList = this.userService.findAll();
            for (UserEntity entity:entityList){
                this.userService.delete(entity);
            }
            return new ResponseEntity(new StatusDTO( 1,"All Deleted Sucessfully"),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO( 1,"Exception Accured !!"),HttpStatus.OK);
        }
    }

}
