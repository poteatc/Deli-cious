package com.pluralsight.model.enums;

import com.pluralsight.model.Drink;

public enum DrinkType {
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
            if (drinkType.ordinal() + 1 == choice) {
                return drinkType;
            }
        }
        return null; // Return null if the code does not match any DrinkType
    }
}
