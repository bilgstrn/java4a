package com.tobeto.java4a.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table(name="orders")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="customer_id")
    private Customer customer;


    @ManyToOne
    @JoinColumn(name="delivery_address_id")
    private Address deliveryAddress;

    @Column(name="total_amount")
    private double totalAmount;

    @Column(name="order_date")
    private LocalDate orderDate;

    @Column(name="shipment_fee")
    private double shipmentFee;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetails;

    @ManyToOne
    @JoinColumn(name="payment_id")
    private Payment payment;

    @OneToMany(mappedBy = "order")
    private List<Shipment> shipments;
}
