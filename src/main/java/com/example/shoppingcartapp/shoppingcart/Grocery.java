package com.example.shoppingcartapp.shoppingcart;

public class Grocery extends Product {
    public Grocery(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void display() {
        System.out.println("[Grocery] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
