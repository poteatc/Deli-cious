package com.pluralsight.model.enums;

import com.pluralsight.model.Drink;

// Enum for Drink sizes
    public enum DrinkSize {
        NONE("None", 0.0),
        SMALL("Small", 2.00),
        MEDIUM("Medium", 2.50),
        LARGE("Large", 3.00);

        private final String description;
        private final double price;

        DrinkSize(String description, double basePrice) {
            this.description = description;
            this.price = basePrice;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }

        // Method to get DrinkSize enum from an integer code
        public static DrinkSize fromChoice(int choice) {
            for (DrinkSize drinkSize : DrinkSize.values()) {
                if (drinkSize.ordinal() == choice) {
                    return drinkSize;
                }
            }
            return null; // Return null if the code does not match any DrinkSize
        }
    }