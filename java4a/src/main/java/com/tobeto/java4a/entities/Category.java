package com.tobeto.java4a.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
@Table(name="categories")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category
{
    @Column(name="id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    //Bir kategorinin birden fazla ürünü vardır.
    //mappedBy => Bu ilişki diğer classta hangi değişken ile tanımlı o belirtilir. Eşleşme sağlanır.
    @OneToMany(mappedBy = "category") //İlişki kurduğumuz diğer taraftaki değişkenin ismi verilir.
    @JsonIgnore
    private List<Product> product;

}
