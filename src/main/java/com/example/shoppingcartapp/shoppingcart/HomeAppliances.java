package com.example.shoppingcartapp.shoppingcart;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("HomeAppliances")
public class HomeAppliances extends Product {

    public HomeAppliances() {
        // Required by JPA — it needs a no-argument constructor
    }

    public HomeAppliances(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println("[Home Appliances] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
