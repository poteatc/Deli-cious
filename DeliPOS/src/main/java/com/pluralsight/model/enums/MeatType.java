package com.pluralsight.model.enums;

public enum MeatType {
    STEAK("Steak"),
    HAM("Ham"),
    SALAMI("Salami"),
    ROAST_BEEF("Roast Beef"),
    CHICKEN("Chicken"),
    BACON("Bacon");

    private final String description;

    // Constructor to initialize the description
    MeatType(String description) {
        this.description = description;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Method to get MeatTYpe enum from an integer code
    public static MeatType fromChoice(int choice) {
        for (MeatType meatType : MeatType.values()) {
            if (meatType.ordinal() + 1 == choice) {
                return meatType;
            }
        }
        return null; // Return null if the code does not match any MeatType
    }
}