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
}