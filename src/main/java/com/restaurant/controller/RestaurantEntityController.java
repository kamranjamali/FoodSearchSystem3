package com.restaurant.controller;

import com.restaurant.Transformer.CustomerTransformer;
import com.restaurant.Transformer.RestaurantTransformer;
import com.restaurant.dto.CustomerDto;
import com.restaurant.dto.RestaurantDto;
import com.restaurant.dto.StatusDTO;
import com.restaurant.entities.CustomerEntity;
import com.restaurant.entities.RestaurantEntity;
import com.restaurant.entities.UserEntity;
import com.restaurant.service.RestaurantService;
import com.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantEntityController {

    @Autowired
    private RestaurantService restaurantService;
    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public ResponseEntity<StatusDTO> create(@ModelAttribute RestaurantDto restaurantDto) {
        try {
            UserEntity userEntity = this.userService.findById(Long.parseLong(restaurantDto.getUserDto().getId()));
            if(userEntity==null){
                return new ResponseEntity(new StatusDTO(0,"User Not Found With this Id"),HttpStatus.NOT_FOUND);
            }else {
                RestaurantEntity restaurantEntity = RestaurantTransformer.getRestaurantEntityFromDto(restaurantDto);
                restaurantEntity=this.restaurantService.create(restaurantEntity);
                RestaurantDto restaurantDto1 = RestaurantTransformer.getRestaurantDtoFromEntity(restaurantEntity);
                return new ResponseEntity(new StatusDTO(1, "Restaurant Created Successfully", restaurantDto1), HttpStatus.CREATED);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<StatusDTO> updateRestaurant(@ModelAttribute RestaurantDto restaurantDto){
        try{
            RestaurantEntity restaurantEntity = restaurantService.findById(Long.parseLong(restaurantDto.getId()));
            if(restaurantEntity == null){
                return new ResponseEntity(new StatusDTO(0,"Restaurant Id not found"),HttpStatus.NOT_FOUND);
            }else{
                UserEntity user = userService.findById(Long.parseLong(restaurantDto.getUserDto().getId()));
                if(user == null){
                    return new ResponseEntity(new StatusDTO(0,"User Not Exits With this Id"),HttpStatus.NOT_FOUND);
                }
                RestaurantEntity updateRestaurant = RestaurantTransformer.updateRestaurant(restaurantEntity, restaurantDto);
                RestaurantEntity update = restaurantService.update(updateRestaurant);
                RestaurantDto updatedRestaurantDto = RestaurantTransformer.getRestaurantDtoFromEntity(update);
                return new ResponseEntity(new StatusDTO(1,"Restaurant Updated Successfully",updatedRestaurantDto),HttpStatus.OK);
            }
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured"+e.getMessage()),HttpStatus.OK);
        }
    }

    @GetMapping("/get/{restaurantId}")
    public ResponseEntity<StatusDTO> findById(@PathVariable Long restaurantId) {
        try {
            RestaurantEntity restaurantEntity = this.restaurantService.findById(restaurantId);
            if (restaurantEntity != null) {
                RestaurantDto restaurantDto = RestaurantTransformer.getRestaurantDtoFromEntity(restaurantEntity);
                return new ResponseEntity(restaurantDto, HttpStatus.OK);
            } else {
                return new ResponseEntity(new StatusDTO(0, "Restaurant Id Not Found "), HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0, "Exception Accured "+e.getMessage()), HttpStatus.OK);
        }
    }

    @GetMapping("/get-all")
    public List<RestaurantDto> findAll() {
        try {
            List<RestaurantEntity> restaurantEntities = restaurantService.findAll();
            List<RestaurantDto> restaurantDtoList = RestaurantTransformer.getRestaurantDtoListFromEntities(restaurantEntities);
            return restaurantDtoList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    //delete Restaurant
    @DeleteMapping("/delete/{restaurantId}")
    public ResponseEntity<StatusDTO> delete(@PathVariable Long  restaurantId){
        try {
            RestaurantEntity restaurantEntity = restaurantService.findById(restaurantId);
            if(restaurantEntity==null){
                return new ResponseEntity(new StatusDTO(0,"Restaurant Id Not Exist"),HttpStatus.NOT_FOUND);
            }
            restaurantService.delete(restaurantId);
            return new ResponseEntity(new StatusDTO(1,"Restaurant deleted Successfully"),HttpStatus.OK);
        }catch (Exception e ){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception"+e.getMessage()),HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete-all")
    public ResponseEntity<StatusDTO> deleteAll(){
        try{
            List<RestaurantEntity> restaurantEntities = restaurantService.findAll();
            this.restaurantService.deleteAll(restaurantEntities);
            return new ResponseEntity(new StatusDTO(1,"All RestaurantEntity Deleted"),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity(new StatusDTO(0,"Exception Accured"+e.getMessage()),HttpStatus.OK);
        }
    }


}