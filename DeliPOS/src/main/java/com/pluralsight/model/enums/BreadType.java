package com.pluralsight.model.enums;

public enum BreadType {
    NONE("None"),
    WHITE("White bread"),
    WHEAT("Wheat bread"),
    RYE("Rye bread"),
    WRAP("Wrap"),
    TORTILLA("Tortilla Shell");

    private final String description; // Description of the bread type

    // Constructor to initialize the description for each enum value
    BreadType(String description) {
        this.description = description;
    }

    // Getter to retrieve the description of the bread type
    public String getDescription() {
        return description;
    }

    /**
     * Method to get a BreadType enum from an integer choice.
     *
     * @param choice the integer corresponding to the ordinal value of the enum
     * @return the BreadType that matches the choice, or null if no match
     */
    public static BreadType fromChoice(int choice) {
        for (BreadType breadType : BreadType.values()) {
            if (breadType.ordinal() == choice) { // Check if the ordinal matches the choice
                return breadType;
            }
        }
        return null; // Return null if the choice does not match any BreadType
    }
}