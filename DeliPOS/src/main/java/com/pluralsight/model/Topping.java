package com.pluralsight.model;

import com.pluralsight.model.enums.SandwichSize;

public abstract class Topping implements Priceable {
    // Enum for different topping types (Meat, Cheese, Regular) with their price details
    public enum ToppingType {
        MEAT("Meat Premium Topping", 1.00, .50),
        CHEESE("Cheese Premium Topping", .75, .30),
        REGULAR("Regular Topping", 0.00, 0.00);

        private final String description;  // Description of the topping
        private final double basePrice;    // Base price for the topping
        private final double extraPrice;   // Extra price if the topping is added in extra quantity

        // Constructor for initializing each topping type with its details
        ToppingType(String description, double basePrice, double extraPrice) {
            this.description = description;
            this.basePrice = basePrice;
            this.extraPrice = extraPrice;
        }

        // Getter for the description of the topping
        public String getDescription() {
            return description;
        }
    }

    private final SandwichSize sandwichSize;  // Size of the sandwich (Small, Medium, Large)
    private final ToppingType toppingType;    // Type of topping (Meat, Cheese, Regular)
    private final boolean hasExtra;           // Whether the topping is extra

    // Constructor for initializing a topping with sandwich size, topping type, and extra flag
    public Topping(SandwichSize sandwichSize, ToppingType toppingType, boolean hasExtra) {
        this.sandwichSize = sandwichSize;
        this.toppingType = toppingType;
        this.hasExtra = hasExtra;
    }

    // Method to calculate the price of the topping based on sandwich size and extra topping
    @Override
    public double getPrice() {
        double price = 0.0;
        int sizeMultiplier = 1;  // Default multiplier for Small size

        // Adjust the size multiplier based on the sandwich size
        switch (sandwichSize) {
            case MEDIUM -> sizeMultiplier = 2;
            case LARGE -> sizeMultiplier = 3;
        }

        // Calculate price based on topping type and whether extra topping is selected
        switch (toppingType) {
            case MEAT -> {
                price += ToppingType.MEAT.basePrice;  // Add the base price of meat
                if (hasExtra) {
                    price += ToppingType.MEAT.extraPrice;  // Add extra price if applicable
                }
            }
            case CHEESE -> {
                price += ToppingType.CHEESE.basePrice;  // Add the base price of cheese
                if (hasExtra) {
                    price += ToppingType.CHEESE.extraPrice;  // Add extra price if applicable
                }
            }
        }

        // Return the final price, adjusted by the size multiplier
        return price * sizeMultiplier;
    }

    // Method to check if the topping is extra
    public boolean withExtra() {
        return hasExtra;
    }

    // Getter for the topping type (Meat, Cheese, etc.)
    public ToppingType getToppingType() {
        return toppingType;
    }
}
