package com.pluralsight.model.enums;

public enum ChipType {
    DORITOS("Doritos"),
    LAYS("Lays"),
    SUN_CHIPS("Sun Chips");
    //NONE("No Chips Selected");

    private final String description;

    // Constructor to initialize the description
    ChipType(String description) {
        this.description = description;
    }

    // Getter for the description
    public String getDescription() {
        return description;
    }

    // Method to get ChipType enum from an integer code
    public static ChipType fromChoice(int choice) {
        for (ChipType chipType : ChipType.values()) {
            if (chipType.ordinal() + 1 == choice) {
                return chipType;
            }
        }
        return null; // Return null if the code does not match any ChipType
    }
}
