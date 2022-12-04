package com.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "gallery_table")
public class GalleryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;
    @Column(name="image_url")
    private String imageUrl;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurantEntity;

}
