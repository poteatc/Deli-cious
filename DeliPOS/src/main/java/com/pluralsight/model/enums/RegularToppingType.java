package com.pluralsight.model.enums;

public enum RegularToppingType {
    NONE("None"),
    LETTUCE("Lettuce"),
    PEPPERS("Peppers"),
    ONIONS("Onions"),
    TOMATOES("Tomatoes"),
    JALEPENOS("Jalapenos"),
    CUCUMBERS("Cucumbers"),
    PICKLES("Pickles"),
    GUACAMOLE("Guacamole"),
    MUSHROOMS("Mushrooms"),
    MAYO("Mayo"),
    MUSTARD("Mustard"),
    KETCHUP("Ketchup"),
    RANCH("Ranch"),
    THOUSAND_ISLAND("Thousand Island"),
    VINAIGRETTE("Vinaigrette"),
    AU_JUS("Au Jus"),
    SAUCE("Sauce");

    private final String description;

    RegularToppingType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    // Method to get RegularTopping enum from an integer code
    public static RegularToppingType fromChoice(int choice) {
        for (RegularToppingType regularToppingType : RegularToppingType.values()) {
            if (regularToppingType.ordinal() == choice) {
                return regularToppingType;
            }
        }
        return null; // Return null if the code does not match any ChipType
    }
}