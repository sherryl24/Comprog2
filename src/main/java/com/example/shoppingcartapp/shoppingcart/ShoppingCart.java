package com.example.shoppingcartapp.shoppingcart;

import java.util.*;

public class ShoppingCart {
    private final List<Product> items = new ArrayList<>();
    public boolean addItem(Product product) {
        for (Product p : items) {
            if (p.getId() == product.getId()) {
                System.out.println(" Item with ID " + product.getId() + " already exists in the cart.");
                return false;
            }
        }
        items.add(product);
        System.out.println(" Added: " + product.getName() + " | Current items in cart: " + items.size());
        return true;
    }

    // Show all items in the cart (Console method, unused by the web app)
    public void showItems() {
        if (items.isEmpty()) {
            System.out.println(" Your cart is currently empty.");
        } else {
            System.out.println("\n--- Cart Items ---");
            // The display() method is part of your console app structure, so we leave it.
            // for (Product p : items) { p.display(); }
            System.out.println("--------------------");
            System.out.printf(" Total Price: $%.2f%n", calculateTotalPrice());
            System.out.println("Total items: " + items.size());
        }
    }

    public boolean updateItem(int id, String newName, double newPrice) {
        for (Product p : items) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("✏ Successfully updated item with ID: " + id);
                return true;
            }
        }
        System.out.println(" Item with ID " + id + " not found in the cart.");
        return false;
    }

    public boolean removeItem(int id) {
        Iterator<Product> iterator = items.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                System.out.println("🗑️ Removed item with ID: " + id + " | Remaining items: " + items.size());
                return true;
            }
        }
        System.out.println(" Item with ID " + id + " not found in the cart.");
        return false;
    }

    // Calculates and returns the total price of all items in the cart
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Product product : items) {
            total += product.getPrice();
        }
        return total;
    }
    public List<Product> getItems() {
        // Return a read-only list for safety
        return Collections.unmodifiableList(items);
    }
}