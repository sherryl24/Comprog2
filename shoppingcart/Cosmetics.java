package shoppingcart;

// Represents a product in the "Cosmetics" category
public class Cosmetics extends Product {

    // Constructor to initialize a Cosmetics product with ID, name, and price
    public Cosmetics(int id, String name, double price) {
        super(id, name, price); // Call the constructor of the abstract Product class
    }

    // Overrides the abstract display method to print product details in a category-specific format
    @Override
    public void display() {
        System.out.println("[Cosmetics] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
