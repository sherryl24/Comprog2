package com.example.shoppingcartapp.controller;

import com.example.shoppingcartapp.shoppingcart.ShoppingCart;
import com.example.shoppingcartapp.shoppingcart.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ShoppingCartController {

    // The cart instance used across all requests
    private final ShoppingCart cart = new ShoppingCart();

    @GetMapping("/") // Maps to the root path
    public String showCart(Model model) {

        List<Product> cartItems = cart.getItems();
        model.addAttribute("cartItems", cartItems);

        double total = cart.calculateTotalPrice();
        model.addAttribute("cartTotal", total);

        return "index";
    }

    @PostMapping("/cart/add")
    public String addItem(@RequestParam int id,
                          @RequestParam String name,
                          @RequestParam double price,
                          @RequestParam String category,
                          RedirectAttributes redirectAttributes) {

        // Use a switch statement to create the correct subclass based on category
        Product newItem = switch (category) {
            case "Electronics" -> new Electronics(id, name, price);
            case "Grocery" -> new Grocery(id, name, price);
            case "HomeAppliances" -> new HomeAppliances(id, name, price);
            case "SchoolSupplies" -> new SchoolSupplies(id, name, price);
            case "Cosmetics" -> new Cosmetics(id, name, price);
            default -> null;
        };

        if (newItem != null) {
            // Check the boolean return value to handle duplicates
            boolean added = cart.addItem(newItem);

            if (added) {
                redirectAttributes.addAttribute("status", "success");
                redirectAttributes.addAttribute("message", name + " added successfully!");
            } else {
                // If not added, it's a duplicate ID (handled by ShoppingCart.java)
                redirectAttributes.addAttribute("status", "error");
                redirectAttributes.addAttribute("message", "Item ID " + id + " already exists. Please choose a unique ID or use Update.");
            }
        } else {
            redirectAttributes.addAttribute("status", "error");
            redirectAttributes.addAttribute("message", "Invalid category selected.");
        }

        // Redirect back to the main cart page, which is now /
        return "redirect:/";
    }

    @PostMapping("/cart/update")
    public String updateItem(@RequestParam int id,
                             @RequestParam String newName,
                             @RequestParam double newPrice,
                             RedirectAttributes redirectAttributes) {

        // Relies on cart.updateItem() returning a boolean
        boolean updated = cart.updateItem(id, newName, newPrice);

        if (updated) {
            redirectAttributes.addAttribute("status", "success");
            redirectAttributes.addAttribute("message", "Item ID " + id + " updated successfully to " + newName + ".");
        } else {
            redirectAttributes.addAttribute("status", "error");
            redirectAttributes.addAttribute("message", "Item ID " + id + " not found for update.");
        }

        return "redirect:/";
    }

    @PostMapping("/cart/remove")
    public String removeItem(@RequestParam int id,
                             RedirectAttributes redirectAttributes) {

        // Relies on cart.removeItem() returning a boolean
        boolean removed = cart.removeItem(id);

        if (removed) {
            redirectAttributes.addAttribute("status", "success");
            redirectAttributes.addAttribute("message", "Item ID " + id + " removed successfully.");
        } else {
            redirectAttributes.addAttribute("status", "error");
            redirectAttributes.addAttribute("message", "Item ID " + id + " not found for removal.");
        }

        return "redirect:/";
    }
}