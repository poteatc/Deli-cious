package com.pluralsight.model;

import com.pluralsight.model.enums.ChipType;

/**
 * Represents a Chip product, extending from Product.
 * Chips have a fixed price, and the price is multiplied by the quantity purchased.
 */
public class Chip extends Product {
    private static final double CHIP_PRICE = 1.50; // Fixed price for a single order of chips
    private final ChipType chipType; // Type of chips (e.g., Doritos, Lays, etc.)

    /**
     * Constructor to initialize the chip product with a specific chip type and quantity.
     *
     * @param chipType the type of chips (e.g., Doritos, Lays, etc.)
     * @param quantity the quantity of chips to be added to the order
     */
    public Chip(ChipType chipType, int quantity) {
        super(quantity); // Initialize the quantity in the superclass
        this.chipType = chipType; // Set the chip type for this order
    }

    /**
     * Returns a formatted string representation of the chip product, including the chip type and price.
     *
     * @return a string describing the chip type and its price
     */
    @Override
    public String getName() {
        return String.format("+ %s: $%.2f", chipType.getDescription(), getPrice()); // Return chip description with price
    }

    /**
     * Returns the price of the chips based on their quantity.
     * If the chip type is NONE, the price is set to zero (i.e., no chips selected).
     *
     * @return the total price of the chips
     */
    @Override
    public double getPrice() {
        if (chipType == ChipType.NONE) {
            return 0; // No chips selected, price is 0
        }
        return CHIP_PRICE * getQuantity(); // Multiply fixed price by quantity
    }
}
