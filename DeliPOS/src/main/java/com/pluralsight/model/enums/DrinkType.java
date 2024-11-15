package com.pluralsight.model.enums;

/**
 * Enum representing different types of drinks available for selection.
 */
public enum DrinkType {
    NONE("None"),       // No drink selected
    TEA("Tea"),         // Tea option
    WATER("Water"),     // Water option
    COLA("Cola");       // Cola option

    private final String description; // Description of the drink type

    /**
     * Constructor to initialize the description of the drink type.
     *
     * @param description a descriptive name for the drink type
     */
    DrinkType(String description) {
        this.description = description;
    }

    /**
     * Getter for the description of the drink type.
     *
     * @return the description of the drink type
     */
    public String getDescription() {
        return description;
    }

    /**
     * Converts an integer choice to a corresponding DrinkType enum value.
     *
     * @param choice the integer representing the ordinal of the enum
     * @return the matching DrinkType, or null if the choice is invalid
     */
    public static DrinkType fromChoice(int choice) {
        for (DrinkType drinkType : DrinkType.values()) {
            if (drinkType.ordinal() == choice) { // Match choice to enum ordinal
                return drinkType;
            }
        }
        return null; // Return null if no match is found
    }
}
