package com.pluralsight.model.enums;

public enum SandwichSize {
    SMALL("4\""),
    MEDIUM("8\""),
    LARGE("12\"");

    private final String description;

    // Constructor to initialize the description
    SandwichSize(String description) {
        this.description = description;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Method to get SandwichSize enum from an integer code
    public static SandwichSize fromChoice(int choice) {
        for (SandwichSize sandwichSize : SandwichSize.values()) {
            if (sandwichSize.ordinal() + 1 == choice) {
                return sandwichSize;
            }
        }
        return null; // Return null if the code does not match any ChipType
    }

}