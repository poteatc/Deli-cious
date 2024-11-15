package com.pluralsight.model;

import com.pluralsight.model.enums.CheeseType;
import com.pluralsight.model.enums.SandwichSize;

/**
 * Represents a Cheese topping in a sandwich.
 * Inherits from the Topping class and adds functionality for cheese type and extra cheese.
 */
public class Cheese extends Topping {
    private final CheeseType cheeseType; // Type of cheese selected for the sandwich

    /**
     * Constructor to initialize the cheese topping with a specific size, cheese type, and whether it has extra cheese.
     *
     * @param sandwichSize the size of the sandwich (e.g., small, medium, large)
     * @param cheeseType the type of cheese to add to the sandwich
     * @param hasExtra boolean flag indicating if extra cheese is requested
     */
    public Cheese(SandwichSize sandwichSize, CheeseType cheeseType, boolean hasExtra) {
        super(sandwichSize, Topping.ToppingType.CHEESE, hasExtra); // Call the constructor of the superclass
        this.cheeseType = cheeseType; // Assign the selected cheese type
    }

    /**
     * Returns a string representation of the cheese topping, including the cheese type, whether it has extra cheese,
     * and the price of the topping.
     *
     * @return a formatted string describing the cheese topping
     */
    @Override
    public String toString() {
        String s = cheeseType.getDescription(); // Get the description of the selected cheese type
        s += withExtra() ? " with extra" : ""; // Append "with extra" if extra cheese is requested
        return String.format("\t+ %s costs: $%.2f", s, getPrice()); // Return the formatted string with price
    }
}
