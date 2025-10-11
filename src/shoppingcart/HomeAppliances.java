package shoppingcart;

public class HomeAppliances extends Product {
    public HomeAppliances(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void display() {
        System.out.println("[Home Appliances] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
