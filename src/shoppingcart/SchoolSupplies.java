package shoppingcart;

public class SchoolSupplies extends Product {
    public SchoolSupplies(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void display() {
        System.out.println("[School Supplies] " + getId() + " - " + getName() + " : $" + String.format("%.2f", getPrice()));
    }
}
