package com.example.shoppingcartapp.shoppingcart;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Cosmetics")
public class Cosmetics extends Product {

    public Cosmetics() {
        // Required by JPA (must have a no-argument constructor)
    }

    public Cosmetics(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println("[Cosmetics] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
