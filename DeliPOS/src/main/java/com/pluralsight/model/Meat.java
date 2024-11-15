package com.pluralsight.model;

import com.pluralsight.model.enums.MeatType;
import com.pluralsight.model.enums.SandwichSize;

/**
 * Represents a meat topping on a sandwich, extending from the Topping class.
 * The meat has a type (e.g., Steak, Chicken) and an option for extra.
 */
public class Meat extends Topping {
    private final MeatType meatType; // Type of meat topping (e.g., Steak, Ham, Chicken)

    /**
     * Constructor to initialize a meat topping with a specified sandwich size, meat type, and extra option.
     *
     * @param sandwichSize the size of the sandwich (e.g., Small, Medium, Large)
     * @param meatType the type of meat (e.g., Steak, Ham, Chicken)
     * @param hasExtra whether extra meat is requested
     */
    public Meat(SandwichSize sandwichSize, MeatType meatType, boolean hasExtra) {
        super(sandwichSize, Topping.ToppingType.MEAT, hasExtra);
        this.meatType = meatType;
    }

    /**
     * Returns a string representation of the meat topping, including its type and the extra option.
     *
     * @return a formatted string showing the meat type and its cost
     */
    @Override
    public String toString() {
        String description = meatType.getDescription(); // Get the description of the meat type
        if (withExtra()) { // If extra meat is requested
            description += " with extra"; // Append " with extra" to the description
        }
        return String.format("\t+ %s costs: $%.2f", description, getPrice());
    }
}
