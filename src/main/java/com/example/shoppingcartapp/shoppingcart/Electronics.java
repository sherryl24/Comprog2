package com.example.shoppingcartapp.shoppingcart;

public class Electronics extends Product {
    public Electronics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void display() {
        System.out.println("[Electronics] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
