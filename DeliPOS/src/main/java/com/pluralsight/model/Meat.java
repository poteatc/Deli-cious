package com.pluralsight.model;

import java.util.Map;

public class Meat extends PremiumTopping {
    // Base price for the first unit by topping size
    private static final Map<Size, Double> MEAT_BASE_PRICES = Map.of(
            Size.SMALL, 1.00,
            Size.MEDIUM, 1.50,
            Size.LARGE, 2.00
    );

    // Upcharge for each additional unit by topping size
    private static final Map<Size, Double> MEAT_UPCHARGES = Map.of(
            Size.SMALL, 0.50,
            Size.MEDIUM, 0.75,
            Size.LARGE, 1.00
    );

    public Meat(Size toppingSize, Size sandwichSize, int quantity) {
        super(toppingSize, sandwichSize, quantity);  // Pass both topping size and sandwich size to the superclass
    }

    @Override
    protected double getBasePriceBySize() {
        return MEAT_BASE_PRICES.getOrDefault(toppingSize, 0.0);
    }

    @Override
    protected double getUpchargeBySize() {
        return MEAT_UPCHARGES.getOrDefault(toppingSize, 0.0);
    }
}
