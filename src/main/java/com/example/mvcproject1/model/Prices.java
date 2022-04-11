package com.example.mvcproject1.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="prices")
public class Prices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "price1")
    private String price1;

    @Column(name = "date1")
    private String date1;

    @Column(name = "price2")
    private String price2;

    @Column(name = "date2")
    private String date2;

    @Column(name = "price3")
    private String price3;

    @Column(name = "date3")
    private String date3;

    @JsonIgnore
    @ManyToOne()
    @JoinColumn(name ="product_id")
    private Product product;

}
