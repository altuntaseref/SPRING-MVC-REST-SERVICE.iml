package com.example.mvcproject1.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="prices")
    private String prices;

    @Column(name="dates")
    private String dates;

    @Column(name="title")
    private String title;

    @Column(name="brand")
    private String brand;

    @Column(name="url")
    private String url;

    @Column(name="category")
    private String category;

    @JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<Prices> prices2;

}


