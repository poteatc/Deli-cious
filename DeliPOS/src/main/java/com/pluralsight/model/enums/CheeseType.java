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

}
