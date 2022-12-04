package com.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantDto {

    private String id;
    private String restaurantName;
    private String description;
    private String longitude;
    private String latitude;
    private String email;
    private String websiteUrl;
    private String city;
    private String country;

    //relations
//  private AddressDto addressDto;
    private UserDto userDto;
    private List<MenuItemDto> menuItemDtos;
    private List<GalleryDto> galleryDtos;


}
