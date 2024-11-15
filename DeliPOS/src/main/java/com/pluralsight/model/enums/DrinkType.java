package com.pluralsight.model.enums;

public enum DrinkType {
    NONE("None"),
    TEA("Tea"),
    WATER("Water"),
    COLA("Cola");

    private final String description;

    DrinkType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // Method to get DrinkType enum from an integer code
    public static DrinkType fromChoice(int choice) {
        for (DrinkType drinkType : DrinkType.values()) {
            if (drinkType.ordinal() == choice) {
                return drinkType;
            }
        }
        return null;
    }
}
