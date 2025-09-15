package shoppingcart;

import java.util.*;

public class ShoppingCart {
    // List to store items added to the shopping cart
    private final List<Product> items = new ArrayList<>();

    // Adds a product to the cart after checking for duplicate IDs
    public void addItem(Product product) {
        for (Product p : items) {
            if (p.getId() == product.getId()) {
                System.out.println("❌ Item with ID " + product.getId() + " already exists in the cart.");
                return; // Prevent adding duplicate item
            }
        }
        items.add(product); // Add the new product
        System.out.println("✅ Added: " + product.getName() + " | Current items in cart: " + items.size());
    }

    // Displays all items currently in the cart, along with total price and count
    public void showItems() {
        if (items.isEmpty()) {
            System.out.println("🛒 Your cart is currently empty.");
        } else {
            System.out.println("\n--- Cart Items ---");
            for (Product p : items) {
                p.display(); // Call each product's display method
            }
            System.out.println("--------------------");
            System.out.printf("💰 Total Price: $%.2f%n", calculateTotalPrice()); // Show total cost
            System.out.println("Total items: " + items.size());
        }
    }

    // Updates the name and price of a product by its ID
    public void updateItem(int id, String newName, double newPrice) {
        for (Product p : items) {
            if (p.getId() == id) {
                p.setName(newName);
                p.setPrice(newPrice);
                System.out.println("✏️ Successfully updated item with ID: " + id);
                return; // Stop after finding and updating the item
            }
        }
        System.out.println("❌ Item with ID " + id + " not found in the cart.");
    }

    // Removes a product from the cart based on its ID
    public void removeItem(int id) {
        Iterator<Product> iterator = items.iterator();
        while (iterator.hasNext()) {
            Product p = iterator.next();
            if (p.getId() == id) {
                iterator.remove(); // Safely remove the item using iterator
                System.out.println("🗑️ Removed item with ID: " + id + " | Remaining items: " + items.size());
                return;
            }
        }
        System.out.println("❌ Item with ID " + id + " not found in the cart.");
    }

    // Calculates and returns the total price of all items in the cart
    public double calculateTotalPrice() {
        double total = 0.0;
        for (Product product : items) {
            total += product.getPrice(); // Add each item's price to the total
        }
        return total;
    }
}
