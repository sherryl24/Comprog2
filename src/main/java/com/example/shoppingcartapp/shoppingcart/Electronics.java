package com.example.shoppingcartapp.shoppingcart;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Electronics")
public class Electronics extends Product {

    public Electronics() {
        // Required empty constructor for JPA
    }

    public Electronics(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println("[Electronics] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
