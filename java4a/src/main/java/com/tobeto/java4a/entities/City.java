package com.tobeto.java4a.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="cities")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class City
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "city")
    private List<Address> addresses;

    @OneToMany(mappedBy = "city")
    private List<District> districts;

    @ManyToOne
    @JoinColumn(name="country_id")
    private Country country;
}