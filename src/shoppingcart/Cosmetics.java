package shoppingcart;

public class Cosmetics extends Product {
    public Cosmetics(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void display() {
        System.out.println("[Cosmetics] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
