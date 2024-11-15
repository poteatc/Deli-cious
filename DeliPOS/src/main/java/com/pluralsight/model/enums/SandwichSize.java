package com.pluralsight.model.enums;

/**
 * Enum representing different sizes of sandwiches available for selection.
 */
public enum SandwichSize {
    NONE("None"),             // No size selected
    SMALL("4\""),             // Small sandwich (4 inches)
    MEDIUM("8\""),            // Medium sandwich (8 inches)
    LARGE("12\"");            // Large sandwich (12 inches)

    private final String description; // Description of the sandwich size

    /**
     * Constructor to initialize the description of the sandwich size.
     *
     * @param description a descriptive name for the sandwich size
     */
    SandwichSize(String description) {
        this.description = description;
    }

    /**
     * Getter for the description of the sandwich size.
     *
     * @return the description of the sandwich size
     */
    public String getDescription() {
        return description;
    }

    /**
     * Converts an integer choice to a corresponding SandwichSize enum value.
     *
     * @param choice the integer representing the ordinal of the enum
     * @return the matching SandwichSize, or null if the choice is invalid
     */
    public static SandwichSize fromChoice(int choice) {
        for (SandwichSize sandwichSize : SandwichSize.values()) {
            if (sandwichSize.ordinal() == choice) { // Match choice to enum ordinal
                return sandwichSize;
            }
        }
        return null; // Return null if no match is found
    }
}
