package com.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "restaurant_table")
public class RestaurantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="restaurant_name")
    private String restaurant_name;
    @Column(name="description")
    private String description;
    @Column(name="longitude")
    private Double longitude;
    @Column(name="latitude")
    private Double latitude;
    @Column(name="email")
    private String email;
    @Column(name="website_url")
    private String website_url;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String country;

    @ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(cascade = CascadeType.ALL)
    private List<MenuItemEntity> menuItemEntities;

    @OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL,mappedBy = "restaurantEntity")
    private List<GalleryEntity> galleryEntity;

}
