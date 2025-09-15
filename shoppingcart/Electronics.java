package shoppingcart;

// Represents a product in the "Electronics" category
public class Electronics extends Product {

    // Constructor to initialize an Electronics product with ID, name, and price
    public Electronics(int id, String name, double price) {
        super(id, name, price); // Call the constructor of the abstract Product class
    }

    // Overrides the abstract display method to print product details in a category-specific format
    @Override
    public void display() {
        System.out.println("[Electronics] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
