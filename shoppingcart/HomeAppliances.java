package shoppingcart;

// Represents a product in the "Home Appliances" category
public class HomeAppliances extends Product {

    // Constructor to initialize a Home Appliances product with ID, name, and price
    public HomeAppliances(int id, String name, double price) {
        super(id, name, price); // Call the constructor of the abstract Product class
    }

    // Overrides the abstract display method to print product details in a category-specific format
    @Override
    public void display() {
        System.out.println("[Home Appliances] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
