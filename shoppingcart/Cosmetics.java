package shoppingcart;

// Represents a product in the "Cosmetics" category
public class Cosmetics extends Product {


// Builds a Cosmetics instance using the provided ID, name, and price 
    public Cosmetics(int id, String name, double price) {
        super(id, name, price); // Call the constructor of the abstract Product class
    }

  // Overrides the display() method from Product to provide a customized output.
    @Override
    public void display() {
        System.out.println("[Cosmetics] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}


