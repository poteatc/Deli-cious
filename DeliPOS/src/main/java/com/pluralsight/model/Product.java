package com.pluralsight.model;

/**
 * Abstract class that represents a generic product.
 * Each product will define its own price calculation and name.
 */
public abstract class Product implements Priceable {
    private final int quantity; // Quantity of the product in the order

    /**
     * Constructor to initialize the product with a given quantity.
     *
     * @param quantity the number of items in the product
     */
    public Product(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Abstract method to get the name of the product.
     * Subclasses must provide their own implementation of how the name is generated.
     *
     * @return the name of the product
     */
    public abstract String getName();

    /**
     * Returns the quantity of the product.
     *
     * @return the quantity of the product
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Abstract method to calculate the price of the product.
     * Each subclass will define how to calculate its price based on its specific attributes.
     *
     * @return the price of the product
     */
    @Override
    public abstract double getPrice();
}
