package com.pluralsight.model;

import java.util.Map;

public class Drink extends Product {
    private static final Map<Size, Double> DRINK_PRICES = Map.of(
            Size.SMALL, 1.00,
            Size.MEDIUM, 1.50,
            Size.LARGE, 2.00
    );

    public Drink(Size size, int quantity) {
        super("Drink", 0.0); // The price will be based on the size
        // Add custom handling to set the price based on the size
    }

    @Override
    public double getPrice() {
        return DRINK_PRICES.getOrDefault(getSize(), 0.0);
    }

    private Size getSize() {
        // Assume this method fetches the size of the drink, typically stored in the product or drink object
        return Size.MEDIUM; // Just an example, assuming size is medium
    }
}
