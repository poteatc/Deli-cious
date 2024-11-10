package com.pluralsight.model;

import java.util.Map;

public class Cheese extends PremiumTopping {
    // Base price for the first unit by topping size
    private static final Map<Size, Double> CHEESE_BASE_PRICES = Map.of(
            Size.SMALL, 0.75,
            Size.MEDIUM, 1.25,
            Size.LARGE, 1.75
    );

    // Upcharge for each additional unit by topping size
    private static final Map<Size, Double> CHEESE_UPCHARGES = Map.of(
            Size.SMALL, 0.25,
            Size.MEDIUM, 0.50,
            Size.LARGE, 0.75
    );

    public Cheese(Size toppingSize, Size sandwichSize, int quantity) {
        super(toppingSize, sandwichSize, quantity);  // Pass both topping size and sandwich size to the superclass
    }

    @Override
    protected double getBasePriceBySize() {
        return CHEESE_BASE_PRICES.getOrDefault(toppingSize, 0.0);
    }

    @Override
    protected double getUpchargeBySize() {
        return CHEESE_UPCHARGES.getOrDefault(toppingSize, 0.0);
    }
}
