package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Order implements Priceable {
    private final List<Product> products;

    // Constructor initializes the products list
    public Order() {
        this.products = new ArrayList<>();
    }

    // Method to add a product to the order
    public void addProduct(Product product) {
        products.add(product);
    }

    // Method to get the total price of the order by summing up the prices of all products
    @Override
    public double getPrice() {
        // Streams through the list of products and sums up the price of each product
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    // Optionally, you could also add a method to remove a product from the order
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Getter for the list of products in the order
    public List<Product> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        String s = "";
        for (Product p : products) {
            s += p.getName() + "\n";
        }
        s += String.format("""
        -----------------------
        >>> Order price: $%.2f <<<
        """, getPrice());
        return s;
    }


}