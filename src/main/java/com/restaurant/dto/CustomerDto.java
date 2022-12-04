package com.restaurant.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CustomerDto {

    private String id;
    private String firstName;
    private String lastName;
    private String city;
    private String phone;
    private String email;
    private String password;
    private String country;
    private String addressLine;

}
