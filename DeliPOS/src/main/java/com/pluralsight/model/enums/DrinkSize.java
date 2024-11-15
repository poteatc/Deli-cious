package com.pluralsight.model.enums;

import com.pluralsight.model.Drink;

/**
 * Enum representing different drink sizes and their respective prices.
 */
public enum DrinkSize {
    NONE("None", 0.0),         // Represents no drink selection
    SMALL("Small", 2.00),      // Represents a small-sized drink
    MEDIUM("Medium", 2.50),    // Represents a medium-sized drink
    LARGE("Large", 3.00);      // Represents a large-sized drink

    private final String description; // Description of the drink size
    private final double price;       // Base price for the drink size

    /**
     * Constructor to initialize description and price for each drink size.
     *
     * @param description a descriptive name for the drink size
     * @param basePrice the base price for the drink size
     */
    DrinkSize(String description, double basePrice) {
        this.description = description;
        this.price = basePrice;
    }

    /**
     * Getter for the drink size description.
     *
     * @return the description of the drink size
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for the price of the drink size.
     *
     * @return the base price of the drink size
     */
    public double getPrice() {
        return price;
    }

    /**
     * Converts an integer choice to a corresponding DrinkSize enum value.
     *
     * @param choice the integer representing the ordinal of the enum
     * @return the matching DrinkSize, or null if the choice is invalid
     */
    public static DrinkSize fromChoice(int choice) {
        for (DrinkSize drinkSize : DrinkSize.values()) {
            if (drinkSize.ordinal() == choice) { // Check if the ordinal matches the choice
                return drinkSize;
            }
        }
        return null; // Return null if the choice does not match any DrinkSize
    }
}
