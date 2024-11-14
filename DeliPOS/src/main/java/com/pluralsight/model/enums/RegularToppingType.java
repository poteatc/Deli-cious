package com.pluralsight.model.enums;

public enum RegularToppingType {
    LETTUCE,
    PEPPERS,
    ONIONS,
    TOMATOES,
    JALEPENOS,
    CUCUMBERS,
    PICKLES,
    GUACAMOLE,
    MUSHROOMS,
    MAYO,
    MUSTARD,
    KETCHUP,
    RANCH,
    THOUSAND_ISLAND,
    VINAIGRETTE,
    AU_JUS,
    SAUCE;

    // Method to get RegularTopping enum from an integer code
    public static RegularToppingType fromChoice(int choice) {
        for (RegularToppingType regularToppingType : RegularToppingType.values()) {
            if (regularToppingType.ordinal() + 1 == choice) {
                return regularToppingType;
            }
        }
        return null; // Return null if the code does not match any ChipType
    }
}