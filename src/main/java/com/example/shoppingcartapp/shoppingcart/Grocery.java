package com.example.shoppingcartapp.shoppingcart;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Grocery")
public class Grocery extends Product {

    public Grocery() {
        // Required by JPA (it needs a no-args constructor)
    }

    public Grocery(String name, double price) {
        super(name, price);
    }

    @Override
    public void display() {
        System.out.println("[Grocery] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
