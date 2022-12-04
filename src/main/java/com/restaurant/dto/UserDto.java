package com.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto {

    private String id;
    private String name;
    private String email;
    private String password;
    private String city;
    private String country;
    private String address_line;

    //relations
    private List<RestaurantDto>  restaurantDtos;


//    private AddressDto addressDto;
}
