package com.pluralsight.model.enums;

public enum CheeseType {
    AMERICAN("American Cheese"),
    PROVOLONE("Provolone Cheese"),
    CHEDDAR("Cheddar Cheese"),
    SWISS("Swiss Cheese");

    private final String description;

    CheeseType(String description) {
        this.description = description;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Method to get CheeseType enum from an integer code
    public static CheeseType fromChoice(int choice) {
        for (CheeseType cheeseType : CheeseType.values()) {
            if (cheeseType.ordinal() + 1 == choice) {
                return cheeseType;
            }
        }
        return null; // Return null if the code does not match any ChipType
    }

}
