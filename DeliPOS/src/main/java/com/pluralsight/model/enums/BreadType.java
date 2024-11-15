package com.pluralsight.model.enums;

public enum BreadType {
    NONE("None"),
    WHITE("White bread"),
    WHEAT("Wheat bread"),
    RYE("Rye bread"),
    WRAP("Wrap"),
    TORTILLA("Tortilla Shell");

    private final String description;

    // Constructor to initialize the description
    BreadType(String description) {
        this.description = description;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Method to get BreadType enum from an integer code
    public static BreadType fromChoice(int choice) {
        for (BreadType breadType : BreadType.values()) {
            if (breadType.ordinal() == choice) {
                return breadType;
            }
        }
        return null; // Return null if the code does not match any ChipType
    }
}