package com.example.shoppingcartapp.controller;

import com.example.shoppingcartapp.shoppingcart.ProductRepository;
import com.example.shoppingcartapp.shoppingcart.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ShoppingCartController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String showCart(Model model) {
        // Fetch all products from the database
        List<Product> cartItems = productRepository.findAll();
        model.addAttribute("cartItems", cartItems);

        double total = cartItems.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        model.addAttribute("cartTotal", total);

        return "index";
    }

    @PostMapping("/cart/add")
    public String addItem(@RequestParam String name,
                          @RequestParam double price,
                          @RequestParam String category,
                          RedirectAttributes redirectAttributes) {

        Product newItem = switch (category) {
            case "Electronics" -> new Electronics(name, price);
            case "Grocery" -> new Grocery(name, price);
            case "HomeAppliances" -> new HomeAppliances(name, price);
            case "SchoolSupplies" -> new SchoolSupplies(name, price);
            case "Cosmetics" -> new Cosmetics(name, price);
            default -> null;
        };

        if (newItem != null) {
            productRepository.save(newItem);
            redirectAttributes.addFlashAttribute("status", "success");
            redirectAttributes.addFlashAttribute("message", name + " added successfully!");
        } else {
            redirectAttributes.addFlashAttribute("status", "error");
            redirectAttributes.addFlashAttribute("message", "Invalid category selected.");
        }

        return "redirect:/";
    }

    @PostMapping("/cart/update")
    public String updateItem(@RequestParam Long id,
                             @RequestParam String newName,
                             @RequestParam double newPrice,
                             RedirectAttributes redirectAttributes) {

        Product product = productRepository.findById(id).orElse(null);

        if (product != null) {
            product.setName(newName);
            product.setPrice(newPrice);
            productRepository.save(product);
            redirectAttributes.addFlashAttribute("status", "success");
            redirectAttributes.addFlashAttribute("message", "Item ID " + id + " updated successfully.");
        } else {
            redirectAttributes.addFlashAttribute("status", "error");
            redirectAttributes.addFlashAttribute("message", "Item ID " + id + " not found.");
        }

        return "redirect:/";
    }

    @PostMapping("/cart/remove")
    public String removeItem(@RequestParam Long id,
                             RedirectAttributes redirectAttributes) {

        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            redirectAttributes.addFlashAttribute("status", "success");
            redirectAttributes.addFlashAttribute("message", "Item ID " + id + " removed successfully.");
        } else {
            redirectAttributes.addFlashAttribute("status", "error");
            redirectAttributes.addFlashAttribute("message", "Item ID " + id + " not found.");
        }

        return "redirect:/";
    }
}
