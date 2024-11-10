package com.pluralsight.model;

public enum Size {
    SMALL("4\""),
    MEDIUM("8\""),
    LARGE("12\"");

    private final String description;

    // Constructor to initialize the description
    Size(String description) {
        this.description = description;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }
}