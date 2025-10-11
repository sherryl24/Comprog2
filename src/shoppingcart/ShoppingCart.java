package shoppingcart;

import java.util.*;

public class ShoppingCart {
    private final List<Product> items = new ArrayList<>();

    // Add item with duplicate check
    public void addItem(Product product) {
        for (Product p : items) {
            if (p.getId() == product.getId()) {
                System.out.println(" Item with ID " + product.getId() + " already exists in the cart.");
                return;
            }
        }
        items.add(product);
        System.out.println(" Added: " + product.getName() + " | Current items in cart: " + items.size());
    }

    // Show all items in the cart
    public void showItems() {
        if (items.isEmpty()) {
            System.out.println(" Your cart is currently empty.");
        } else {
            System.out.println("\n--- Cart Items ---");
            for (Product p : items) {
                p.display();
            }
            System.out.println("--------------------");
            System.out.printf(" Total Price: $%.2f%n", calculateTotalPrice());
            System.out.println("Total items: " + items.size());
        }
    }

    // Update an item's details by its ID
    public void updateItem(int id, String newName, double newPrice) {
        for (Product p : items) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("✏ Successfully updated item with ID: " + id);
                return;
            }
        }
        System.out.println(" Item with ID " + id + " not found in the cart.");
    }

    // Remove an item by its ID
    public void removeItem(int id) {
        Iterator<Product> iterator = items.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getId() == id) {
                iterator.remove();
                System.out.println("🗑️ Removed item with ID: " + id + " | Remaining items: " + items.size());
                return;
            }
        }
        System.out.println(" Item with ID " + id + " not found in the cart.");
    }

    // Calculates and returns the total price of all items in the cart
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Product product : items) {
            total += product.getPrice();
        }
        return total;
    }
}