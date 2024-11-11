package com.pluralsight.model;

import java.util.Map;

public class Drink extends Product {
    private static final Map<Size, Double> DRINK_PRICES = Map.of(
            Size.SMALL, 1.00,
            Size.MEDIUM, 1.50,
            Size.LARGE, 2.00
    );

    public Drink(Size size, int quantity) {
        super("Drink", DRINK_PRICES.getOrDefault(size, 0.0) * quantity);  // Assuming price is determined by size and quantity
    }

    @Override
    protected double getPriceBySize() {
        return DRINK_PRICES.getOrDefault(DRINK_PRICES, 0.0);
    }
}
