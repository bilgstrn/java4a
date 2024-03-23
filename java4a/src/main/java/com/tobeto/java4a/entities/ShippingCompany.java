package com.tobeto.java4a.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="shipping_companies")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ShippingCompany
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @OneToMany(mappedBy = "shippingCompany")
    private List<Shipment> shipments;
}
