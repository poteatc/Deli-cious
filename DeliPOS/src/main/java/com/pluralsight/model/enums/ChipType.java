package com.pluralsight.model.enums;

public enum ChipType {
    DORITOS("Doritos"),
    LAYS("Lays"),
    SUN_CHIPS("Sun Chips");

    private final String description;

    // Constructor to initialize the description
    ChipType(String description) {
        this.description = description;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }
}
