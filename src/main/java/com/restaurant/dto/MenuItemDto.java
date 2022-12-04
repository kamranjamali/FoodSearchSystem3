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
public class MenuItemDto {

    private String id;
    private String name;
    private String image;
    private String price;
    private String discount;

    //relation
    private CategoryDto categoryDto;
    private RestaurantDto restaurantDto;
    private List<ReviewDto> reviewDtos;

}
