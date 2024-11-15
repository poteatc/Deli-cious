package com.pluralsight.model;

import com.pluralsight.model.enums.RegularToppingType;
import com.pluralsight.model.enums.SandwichSize;

public class RegularTopping extends Topping {

    private final RegularToppingType regularToppingType; // Type of the regular topping (e.g., Lettuce, Peppers)

    // Constructor to initialize the regular topping with size, type, and extra option
    public RegularTopping(SandwichSize sandwichSize, RegularToppingType regularToppingType, boolean hasExtra) {
        super(sandwichSize, ToppingType.REGULAR, hasExtra); // Calls the superclass constructor
        this.regularToppingType = regularToppingType;
    }

    // Override toString() to return a description of the regular topping
    @Override
    public String toString() {
        return "\t+ " + regularToppingType.getDescription() + ": FREE"; // Regular toppings are free
    }
}
