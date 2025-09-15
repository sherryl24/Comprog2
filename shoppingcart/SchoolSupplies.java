package shoppingcart;

// Represents a specific product category: School Supplies
public class SchoolSupplies extends Product {

    // Constructor to initialize School Supplies item with ID, name, and price
    public SchoolSupplies(int id, String name, double price) {
        super(id, name, price); // Call the constructor of the parent class (Product)
    }

    // Overrides the display method to print item details in a specific format
    @Override
    public void display() {
        System.out.println("[School Supplies] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
