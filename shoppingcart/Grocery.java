package shoppingcart;

// Represents a product in the "Grocery" category
public class Grocery extends Product {

    // Constructor to initialize a Grocery product with ID, name, and price
    public Grocery(int id, String name, double price) {
        super(id, name, price); // Call the constructor of the abstract Product class
    }

    // Overrides the abstract display method to print product details in a category-specific format
    @Override
    public void display() {
        System.out.println("[Grocery] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
