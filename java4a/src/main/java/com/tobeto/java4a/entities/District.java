package com.tobeto.java4a.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="districts")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class District
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "district")
    private List<Address> addresses;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city;

    @Column(name="name")
    private String name;
}
