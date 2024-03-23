package com.tobeto.java4a.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Table(name="payments")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "payment")
    private List<Order> orders;

    @ManyToOne
    @JoinColumn(name="payment_method_id")
    private PaymentMethod paymentMethod;

    @Column(name="payment_date")
    private LocalDate paymentDate;

    @Column(name="amount")
    private BigDecimal amount;
}
