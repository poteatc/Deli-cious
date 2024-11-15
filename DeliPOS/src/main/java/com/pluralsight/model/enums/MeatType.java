package com.pluralsight.model.enums;

/**
 * Enum representing different types of meat available for selection.
 */
public enum MeatType {
    NONE("No Meat"),         // Option for no meat
    STEAK("Steak"),          // Option for steak
    HAM("Ham"),              // Option for ham
    SALAMI("Salami"),        // Option for salami
    ROAST_BEEF("Roast Beef"),// Option for roast beef
    CHICKEN("Chicken"),      // Option for chicken
    BACON("Bacon");          // Option for bacon

    private final String description; // Description of the meat type

    /**
     * Constructor to initialize the description of the meat type.
     *
     * @param description a descriptive name for the meat type
     */
    MeatType(String description) {
        this.description = description;
    }

    /**
     * Getter for the description of the meat type.
     *
     * @return the description of the meat type
     */
    public String getDescription() {
        return description;
    }

    /**
     * Converts an integer choice to a corresponding MeatType enum value.
     *
     * @param choice the integer representing the ordinal of the enum
     * @return the matching MeatType, or null if the choice is invalid
     */
    public static MeatType fromChoice(int choice) {
        for (MeatType meatType : MeatType.values()) {
            if (meatType.ordinal() == choice) { // Match choice to enum ordinal
                return meatType;
            }
        }
        return null; // Return null if no match is found
    }
}
