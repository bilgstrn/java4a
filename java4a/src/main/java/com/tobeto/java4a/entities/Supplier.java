package com.tobeto.java4a.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Table(name="suppliers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Supplier
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    @Column(name="company_name")
    private String companyName;

    @Column(name="fax")
    private String fax;

    @Column(name="total_rating")
    private BigDecimal totalRating;

    @OneToMany(mappedBy = "supplier")
    private List<Product> products;
}
