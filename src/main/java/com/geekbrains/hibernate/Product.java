package com.geekbrains.hibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private double price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "drinks",
            joinColumns = @JoinColumn(name = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "cust_id")
    )
    private List<Customer> cust;

    public Product() {
    }

    public Product(String title,double price) {
        this.title = title;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Catalog: " + id + " " + title;
    }
}
