package com.pluralsight.model.enums;

public enum BreadType {
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
}