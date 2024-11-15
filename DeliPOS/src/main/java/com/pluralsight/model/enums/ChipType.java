package com.pluralsight.model.enums;

public enum ChipType {
    NONE("None"),
    DORITOS("Doritos"),
    LAYS("Lays"),
    SUN_CHIPS("Sun Chips");

    private final String description; // Description of the chip type

    // Constructor to initialize the description for each enum value
    ChipType(String description) {
        this.description = description;
    }

    // Getter to retrieve the description of the chip type
    public String getDescription() {
        return description;
    }

    /**
     * Method to get a ChipType enum from an integer choice.
     *
     * @param choice the integer corresponding to the ordinal value of the enum
     * @return the ChipType that matches the choice, or null if no match
     */
    public static ChipType fromChoice(int choice) {
        for (ChipType chipType : ChipType.values()) {
            if (chipType.ordinal() == choice) { // Check if the ordinal matches the choice
                return chipType;
            }
        }
        return null; // Return null if the choice does not match any ChipType
    }
}
