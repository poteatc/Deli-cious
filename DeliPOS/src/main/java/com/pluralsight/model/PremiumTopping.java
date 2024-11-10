package com.pluralsight.model;

import java.util.Map;

public abstract class PremiumTopping extends Topping {
    private static final Map<Size, Double> EXTRA_CHARGES = Map.of(
            Size.SMALL, 0.25,
            Size.MEDIUM, 0.50,
            Size.LARGE, 0.75
    );

    public PremiumTopping(Size size, int quantity) {
        super(size.toString(), 0.0, quantity); // Calls Topping constructor, using size as name and 0 price initially
    }

    // Abstract method to get the base price for the first unit
    protected abstract double getBasePriceBySize();

    // Abstract method to get the upcharge for additional units
    protected abstract double getUpchargeBySize();

    @Override
    public double getPrice() {
        double totalPrice = 0.0;

        // Apply base price for the first topping
        if (getQuantity() > 0) {
            totalPrice += getBasePriceBySize();
        }

        // Apply upcharge for each additional topping beyond the first
        if (getQuantity() > 1) {
            totalPrice += (getQuantity() - 1) * getUpchargeBySize();
        }

        // Add extra charge based on size (this could be for the whole topping or sandwich)
        double extraCharge = EXTRA_CHARGES.getOrDefault(Size.SMALL, 0.0);
        totalPrice += extraCharge * getQuantity();

        return totalPrice;
    }
}
