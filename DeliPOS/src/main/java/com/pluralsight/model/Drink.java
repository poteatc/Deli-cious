package com.pluralsight.model;

import com.pluralsight.model.enums.DrinkSize;
import com.pluralsight.model.enums.DrinkType;

/**
 * Represents a drink product, extending from the Product class.
 * The drink has a size and type (e.g., tea, cola) with a price based on the selected size and quantity.
 */
public class Drink extends Product {

    private final DrinkSize size; // Size of the drink (e.g., Small, Medium, Large)
    private final DrinkType type; // Type of the drink (e.g., Tea, Cola, Water)

    /**
     * Constructor to initialize a drink product with a specified quantity, size, and type.
     *
     * @param quantity the number of drinks ordered
     * @param size the size of the drink (e.g., Small, Medium, Large)
     * @param type the type of the drink (e.g., Tea, Cola, Water)
     */
    public Drink(int quantity, DrinkSize size, DrinkType type) {
        super(quantity); // Initialize the quantity from the superclass
        this.size = size; // Set the size of the drink
        this.type = type; // Set the type of the drink
    }

    /**
     * Returns a formatted string representation of the drink, including its size, type, and price.
     *
     * @return a string describing the drink with its size, type, and price
     */
    @Override
    public String getName() {
        return String.format("+ %s %s: $%.2f", getSize(), type.getDescription(), getPrice());
    }

    /**
     * Returns the price of the drink based on its size and quantity.
     * The price is determined by the size and is then multiplied by the quantity.
     *
     * @return the total price of the drink
     */
    @Override
    public double getPrice() {
        return size.getPrice() * getQuantity();  // Calculate the price based on size and quantity
    }

    /**
     * Returns the description of the drink's size.
     *
     * @return the description of the size (e.g., Small, Medium, Large)
     */
    public String getSize() {
        return size.getDescription();
    }

    /**
     * Returns the description of the drink's type.
     *
     * @return the description of the drink type (e.g., Tea, Cola, Water)
     */
    public String getType() {
        return type.getDescription();
    }
}
