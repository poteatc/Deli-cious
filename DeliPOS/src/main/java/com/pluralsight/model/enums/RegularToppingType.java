package com.pluralsight.model.enums;

/**
 * Enum representing different types of regular toppings available for selection.
 */
public enum RegularToppingType {
    NONE("None"),             // No topping selected
    LETTUCE("Lettuce"),       // Lettuce topping
    PEPPERS("Peppers"),       // Peppers topping
    ONIONS("Onions"),         // Onions topping
    TOMATOES("Tomatoes"),     // Tomatoes topping
    JALEPENOS("Jalapenos"),   // Jalapenos topping
    CUCUMBERS("Cucumbers"),   // Cucumbers topping
    PICKLES("Pickles"),       // Pickles topping
    GUACAMOLE("Guacamole"),   // Guacamole topping
    MUSHROOMS("Mushrooms"),   // Mushrooms topping
    MAYO("Mayo"),             // Mayo topping
    MUSTARD("Mustard"),       // Mustard topping
    KETCHUP("Ketchup"),       // Ketchup topping
    RANCH("Ranch"),           // Ranch topping
    THOUSAND_ISLAND("Thousand Island"), // Thousand Island topping
    VINAIGRETTE("Vinaigrette"), // Vinaigrette topping
    AU_JUS("Au Jus"),         // Au Jus topping
    SAUCE("Sauce");           // Sauce topping

    private final String description; // Description of the topping type

    /**
     * Constructor to initialize the description of the regular topping type.
     *
     * @param description a descriptive name for the topping type
     */
    RegularToppingType(String description) {
        this.description = description;
    }

    /**
     * Getter for the description of the topping type.
     *
     * @return the description of the topping type
     */
    public String getDescription() {
        return description;
    }

    /**
     * Converts an integer choice to a corresponding RegularToppingType enum value.
     *
     * @param choice the integer representing the ordinal of the enum
     * @return the matching RegularToppingType, or null if the choice is invalid
     */
    public static RegularToppingType fromChoice(int choice) {
        for (RegularToppingType regularToppingType : RegularToppingType.values()) {
            if (regularToppingType.ordinal() == choice) { // Match choice to enum ordinal
                return regularToppingType;
            }
        }
        return null; // Return null if no match is found
    }
}
