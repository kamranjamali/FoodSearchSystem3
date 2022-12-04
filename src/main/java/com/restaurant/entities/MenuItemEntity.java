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
@Setter
@Getter
@Table(name = "menu_table")
public class MenuItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "id")
    private Long id;
    @Column(name="name")
    private String name;
    @Column(name="image")
    private String image;
    @Column(name="price")
    private Double price;
    @Column(name="discount")
    private Double discount;

    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "category_id")
    private CategoryEntity categoryEntity;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant_id")
    private RestaurantEntity restaurantEntity;

    @OneToMany(mappedBy = "menuItemEntity")
    private List<ReviewEntity> reviewEntities;
}
