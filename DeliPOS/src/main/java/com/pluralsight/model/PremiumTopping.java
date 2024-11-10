package com.pluralsight.model;

import java.util.Map;

public abstract class PremiumTopping extends Topping {
    private static final Map<Size, Double> EXTRA_CHARGES = Map.of(
            Size.SMALL, 0.25,
            Size.MEDIUM, 0.50,
            Size.LARGE, 0.75
    );

    protected Size toppingSize; // Size for the topping (e.g., small/medium/large)
    protected Size sandwichSize; // Size for the sandwich (e.g., small/medium/large)

    // Constructor
    public PremiumTopping(Size toppingSize, Size sandwichSize, int quantity) {
        super(null, 0.0, quantity); // Call Topping constructor (name, price, quantity)
        this.toppingSize = toppingSize;
        this.sandwichSize = sandwichSize;
    }

    // Abstract methods for getting prices specific to each topping
    protected abstract double getBasePriceBySize();

    protected abstract double getUpchargeBySize();

    @Override
    public double getPrice() {
        double totalPrice = 0.0;

        // Apply base price for the first topping
        if (quantity > 0) {
            totalPrice += getBasePriceBySize();
        }

        // Apply upcharge for each additional topping beyond the first
        if (quantity > 1) {
            totalPrice += (quantity - 1) * getUpchargeBySize();
        }

        // Add extra charge based on size (applies to the topping, but varies by sandwich size)
        double extraCharge = EXTRA_CHARGES.getOrDefault(sandwichSize, 0.0);
        totalPrice += extraCharge * quantity;

        return totalPrice;
    }
}

