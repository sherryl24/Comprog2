package com.example.shoppingcartapp.shoppingcart;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("SchoolSupplies")
public class SchoolSupplies extends Product {

    public SchoolSupplies() {
        // JPA requires a no-argument constructor
    }

    public SchoolSupplies(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println("[School Supplies] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
