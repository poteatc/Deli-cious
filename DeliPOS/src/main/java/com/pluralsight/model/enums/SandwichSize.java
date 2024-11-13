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

}