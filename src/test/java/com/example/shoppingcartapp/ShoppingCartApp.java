package com.example.shoppingcartapp;

import com.example.shoppingcartapp.shoppingcart.*;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingCartApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();
        int choice;

        do {
            displayMenu();
            choice = getIntInput(scanner, "Enter your choice: ");

            switch (choice) {
                case 1 -> addItem(scanner, cart, "Electronics");
                case 2 -> addItem(scanner, cart, "Grocery");
                case 3 -> addItem(scanner, cart, "Home Appliances");
                case 4 -> addItem(scanner, cart, "School Supplies");
                case 5 -> addItem(scanner, cart, "Cosmetics");
                case 6 -> cart.showItems();
                case 7 -> updateItem(scanner, cart);
                case 8 -> removeItem(scanner, cart);
                case 0 -> System.out.println(" Exiting the application. Goodbye!");
                default -> System.out.println("️ Invalid choice. Please try again.");
            }

        } while (choice != 0);

        scanner.close();
    }

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

    private static int getIntInput(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input. Please enter a number.");
                sc.next(); // Consume the invalid input to prevent an infinite loop
            }
        }
    }

    private static double getDoubleInput(Scanner sc, String prompt) {
        while (true) {
            try {
                System.out.print(prompt);
                return sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println(" Invalid input. Please enter a number.");
                sc.next(); // Consume the invalid input
            }
        }
    }

    private static void addItem(Scanner sc, ShoppingCart cart, String category) {
        int id = getIntInput(sc, "Enter ID: ");
        sc.nextLine(); // Consume the leftover newline
        System.out.print("Enter Item: ");
        String name = sc.nextLine();
        double price = getDoubleInput(sc, "Enter Price: ");

        // This next line is crucial to prevent the scanner bug for the next loop iteration
        sc.nextLine();

        switch (category) {
            case "Electronics" -> cart.addItem(new Electronics(id, name, price));
            case "Grocery" -> cart.addItem(new Grocery(id, name, price));
            case "Home Appliances" -> cart.addItem(new HomeAppliances(id, name, price));
            case "School Supplies" -> cart.addItem(new SchoolSupplies(id, name, price));
            case "Cosmetics" -> cart.addItem(new Cosmetics(id, name, price));
        }
    }

    private static void updateItem(Scanner sc, ShoppingCart cart) {
        int id = getIntInput(sc, "Enter ID of the item to update: ");
        sc.nextLine(); // Consume the leftover newline
        System.out.print("Enter new Name: ");
        String newName = sc.nextLine();
        double newPrice = getDoubleInput(sc, "Enter new Price: ");
        sc.nextLine(); // Consume the leftover newline
        cart.updateItem(id, newName, newPrice);
    }

    private static void removeItem(Scanner sc, ShoppingCart cart) {
        int id = getIntInput(sc, "Enter ID of the item to remove: ");
        sc.nextLine(); // Consume the leftover newline
        cart.removeItem(id);
    }
}