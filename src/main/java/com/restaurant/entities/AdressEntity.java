package com.restaurant.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Getter
@Setter
@Table(name = "address-table")
public class AdressEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address_ID")
    private Long id;
    @Column(name = "city")
    private String city;
    @Column(name = "country")
    private String  country;
    @Column(name = "address_line")
    private String addressLine;
    @Column(name = "post_code")
    private String postCode;


}
