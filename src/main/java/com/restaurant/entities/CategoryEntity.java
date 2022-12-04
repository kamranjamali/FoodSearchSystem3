

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
    @Table(name = "category_table")
    public class CategoryEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        @Column(name="title")
        private String title;
        @Column(name="description")
        private String description;

        @OneToOne(mappedBy = "categoryEntity",cascade = CascadeType.MERGE)
        private MenuItemEntity menuItemEntity;


    }