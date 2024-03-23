package com.tobeto.java4a.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="images")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Image
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="image_url")
    private String imageUrl;

    @ManyToMany(mappedBy = "images")
    private List<Product> products;
}
