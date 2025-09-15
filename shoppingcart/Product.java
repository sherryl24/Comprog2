package shoppingcart;

// Abstract base class representing a general product
public abstract class Product {
    // Common attributes for all product types
    private int id;
    private String name;
    private double price;

    // Constructor to initialize common product fields
    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Getter for product ID
    public int getId() {
        return id;
    }

    // Getter for product name
    public String getName() {
        return name;
    }

    // Setter for product name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for product price
    public double getPrice() {
        return price;
    }

    // Setter for product price
    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method to be implemented by subclasses to display product details
    public abstract void display();
}
