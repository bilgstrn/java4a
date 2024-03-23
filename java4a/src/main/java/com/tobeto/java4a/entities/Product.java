package com.tobeto.java4a.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name="products")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //İlişkiler FK olarak tanımlanmaz.
    //Bir kategoride birden çok ürün vardır.
    @ManyToOne //Hangi classın içindeysem onun tarafıyla başlar.
    @JoinColumn(name="category_id") //Products tablosunda category_id olduğu için(FK) JoinColumn kullanılır.
    private Category category;

    @ManyToOne
    @JoinColumn(name="brand_id")
    private Brand brand;

    @ManyToOne
    @JoinColumn(name="supplier_id")
    private Supplier supplier;

    @Column(name="name")
    private String name;

    @Column(name="stock")
    private int stock;

    @Column(name="unit_price")
    private double unitPrice;

    @Column(name="description")
    private String description;

    @OneToMany(mappedBy = "product")
    private List<Comment> comments;

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;

    @ManyToMany
    @JoinTable(name="product_images",
            joinColumns = @JoinColumn(name="product_id"),
            inverseJoinColumns = @JoinColumn(name="image_id"))
    private List<Image> images;
}
