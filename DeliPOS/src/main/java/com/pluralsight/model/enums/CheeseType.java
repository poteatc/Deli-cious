package com.pluralsight.model.enums;

public enum CheeseType {
    NONE("None"),
    AMERICAN("American Cheese"),
    PROVOLONE("Provolone Cheese"),
    CHEDDAR("Cheddar Cheese"),
    SWISS("Swiss Cheese");

    private final String description; // Description of the cheese type

    // Constructor to initialize the description for each enum value
    CheeseType(String description) {
        this.description = description;
    }

    // Getter to retrieve the description of the cheese type
    public String getDescription() {
        return description;
    }

    /**
     * Method to get a CheeseType enum from an integer choice.
     *
     * @param choice the integer corresponding to the ordinal value of the enum
     * @return the CheeseType that matches the choice, or null if no match
     */
    public static CheeseType fromChoice(int choice) {
        for (CheeseType cheeseType : CheeseType.values()) {
            if (cheeseType.ordinal() == choice) { // Check if the ordinal matches the choice
                return cheeseType;
            }
        }
        return null; // Return null if the choice does not match any CheeseType
    }
}
