package shoppingcart;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        int choice;

        // Main loop to display menu and perform actions based on user input
        do {
            displayMenu();  // Show the options menu
            choice = getIntInput(scanner, "Enter your choice: ");  // Get user's menu choice

            switch (choice) {
                case 1:
                    addItem(scanner, cart, "Electronics");
                    break;
                case 2:
                    addItem(scanner, cart, "Grocery");
                    break;
                case 3:
                    addItem(scanner, cart, "Home Appliances");
                    break;
                case 4:
                    addItem(scanner, cart, "School Supplies");
                    break;
                case 5:
                    addItem(scanner, cart, "Cosmetics");
                    break;
                case 6:
                    cart.showItems();  // Show all items in the cart
                    break;
                case 7:
                    updateItem(scanner, cart);  // Update an item in the cart
                    break;
                case 8:
                    removeItem(scanner, cart);  // Remove an item from the cart
                    break;
                case 0:
                    System.out.println("👋 Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("⚠️ Invalid choice. Please try again.");
                    break;
            }

        } while (choice != 0);  // Keep running until user chooses to exit

        scanner.close();  // Close the scanner resource
    }

  // Displays the shopping cart’s primary choices for the user  
    private static void displayMenu() {
        System.out.println("\n=== Shopping Cart Menu ===");
        System.out.println("1. Add Electronics");
        System.out.println("2. Add Grocery");
        System.out.println("3. Add Home Appliances");
        System.out.println("4. Add School Supplies");
        System.out.println("5. Add Cosmetics");
        System.out.println("6. Show Cart");
        System.out.println("7. Update Item");
        System.out.println("8. Remove Item");
        System.out.println("0. Exit");
    }

    // Reads an integer input from the user safely, handling invalid input
    private static int getIntInput(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                sc.next(); // Clear invalid input to avoid infinite loop
            }
        }
    }

    // Reads a double (decimal) input from the user safely, handling invalid input
    private static double getDoubleInput(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("❌ Invalid input. Please enter a number.");
                sc.next(); // Clear invalid input
            }
        }
    }

    // Adds a new item to the cart based on the selected category
    private static void addItem(Scanner sc, ShoppingCart cart, String category) {
        int id = getIntInput(sc, "Enter ID: ");
        sc.nextLine(); // Consume leftover newline
        System.out.print("Enter Item: ");
        String name = sc.nextLine();
        double price = getDoubleInput(sc, "Enter Price: ");

        sc.nextLine(); // Prevent scanner issues in next input

        // Create and add the appropriate item type to the cart
        switch (category) {
            case "Electronics":
                cart.addItem(new Electronics(id, name, price));
                break;
            case "Grocery":
                cart.addItem(new Grocery(id, name, price));
                break;
            case "Home Appliances":
                cart.addItem(new HomeAppliances(id, name, price));
                break;
            case "School Supplies":
                cart.addItem(new SchoolSupplies(id, name, price));
                break;
            case "Cosmetics":
                cart.addItem(new Cosmetics(id, name, price));
                break;
            default:
                System.out.println("⚠️ Unknown category.");
                break;
        }
    }

    // Updates the name and price of an existing item in the cart
    private static void updateItem(Scanner sc, ShoppingCart cart) {
        int id = getIntInput(sc, "Enter ID of the item to update: ");
        sc.nextLine(); // Consume leftover newline
        System.out.print("Enter new Name: ");
        String newName = sc.nextLine();
        double newPrice = getDoubleInput(sc, "Enter new Price: ");
        sc.nextLine(); // Consume leftover newline
        cart.updateItem(id, newName, newPrice); // Perform the update
    }

  // Deletes a product from the shopping cart using its ID  
    private static void removeItem(Scanner sc, ShoppingCart cart) {
        int id = getIntInput(sc, "Enter ID of the item to remove: ");
        sc.nextLine(); // Consume leftover newline
        cart.removeItem(id); // Remove the item
    }
}
