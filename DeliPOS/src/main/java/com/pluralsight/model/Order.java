package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an order consisting of multiple products. Implements the Priceable interface to calculate the total price.
 */
public class Order implements Priceable {
    private final List<Product> products; // List to hold all products in the order

    /**
     * Constructor to initialize the list of products in the order.
     */
    public Order() {
        this.products = new ArrayList<>();
    }

    /**
     * Adds a product to the order.
     *
     * @param product the product to be added to the order
     */
    public void addProduct(Product product) {
        products.add(product); // Add the product to the list
    }

    /**
     * Removes a product from the order.
     *
     * @param product the product to be removed from the order
     */
    public void removeProduct(Product product) {
        products.remove(product); // Remove the product from the list
    }

    /**
     * Returns the total price of the order by summing the prices of all the products.
     * This method uses streams to sum up the prices of each product.
     *
     * @return the total price of the order
     */
    @Override
    public double getPrice() {
        return products.stream()   // Stream through the list of products
                .mapToDouble(Product::getPrice) // Map each product to its price
                .sum(); // Sum up all the prices
    }

    /**
     * Returns the list of products in the order.
     *
     * @return the list of products in the order
     */
    public List<Product> getProducts() {
        return products;
    }

    /**
     * Returns a string representation of the order, including each product's name and the total price of the order.
     *
     * @return the formatted string representing the order and its total price
     */
    @Override
    public String toString() {
        // Create a string representation of the products in the order
        StringBuilder sb = new StringBuilder();
        for (Product p : products) {
            sb.append(p.getName()).append("\n");
        }

        // Append the total price of the order
        sb.append(String.format("""
        -----------------------
        >>> Order price: $%.2f <<<
        """, getPrice()));

        return sb.toString(); // Return the constructed string
    }
}
