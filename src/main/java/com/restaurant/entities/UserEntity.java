package com.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "user_table")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "phone")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name="password")
    private String password;
    @Column(name = "role")
    private String role;

    @OneToMany(mappedBy = "userEntity",cascade = CascadeType.ALL)
    private List<RestaurantEntity> restaurantEntity;

    @OneToMany
    private List<ReviewEntity> reviewEntity=new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AdressEntity adressEntity;

}


