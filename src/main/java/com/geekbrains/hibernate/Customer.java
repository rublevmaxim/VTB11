package com.geekbrains.hibernate;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    public List<Product> getProd() {
        return prod;
    }

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "drinks",
            joinColumns = @JoinColumn(name = "cust_id"),
            inverseJoinColumns = @JoinColumn(name = "prod_id")
    )
    private List<Product> prod;


    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Catalog: " + id + " " + name;
    }
}
