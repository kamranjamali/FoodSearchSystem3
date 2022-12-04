package com.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReviewDto {

    private String id;
    private String ratings;
    private String comment;

    //relations
    private CustomerDto customerDto;
    private MenuItemDto menuItemDto;

}
