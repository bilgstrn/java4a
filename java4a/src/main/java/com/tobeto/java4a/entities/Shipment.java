package com.tobeto.java4a.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Table(name="shipments")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Shipment
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="shipment_date")
    private LocalDate shipmentDate;

    @Column(name="status")
    private String status;

    @Column(name="tracking_number")
    private String trackingNumber;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name="shipping_company_id")
    private ShippingCompany shippingCompany;
}