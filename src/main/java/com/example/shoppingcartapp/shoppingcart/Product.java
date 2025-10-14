package com.example.shoppingcartapp.shoppingcart;

import jakarta.persistence.*;

@Entity
@Table(name = "products")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "category", discriminatorType = DiscriminatorType.STRING)
public abstract class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Use Long for database IDs

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private double price;

    public Product() {
        // Required by JPA
    }

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getters
    public Long getId() { return id; }

    public String getName() { return name; }

    public double getPrice() { return price; }

    public String getCategory() {
        return this.getClass().getSimpleName();
    }

    // Setters
    public void setId(Long id) { this.id = id; }

    public void setName(String name) { this.name = name; }

    public void setPrice(double price) { this.price = price; }

    public abstract void display();
}
