package com.tobeto.java4a.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="addresses")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name="district_id")
    private District district;

    @Column(name="name")
    private String name;

    @Column(name="address_details")
    private String addressDetail;

    @Column(name="postal_code")
    private String postalCode;

    @OneToMany(mappedBy = "deliveryAddress")
    private List<Order> orders;

    @ManyToMany(mappedBy = "addresses")
    private List<User> users;
}
