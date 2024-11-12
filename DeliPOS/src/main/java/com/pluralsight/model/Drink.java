package com.pluralsight.model;

public class Drink extends Product {

    // Enum for Drink sizes implementing Priceable
    public enum DrinkSize implements Priceable {
        SMALL("Small", 2.00),
        MEDIUM("Medium", 2.50),
        LARGE("Large", 3.00);

        private final String description;
        private final double basePrice;

        DrinkSize(String description, double basePrice) {
            this.description = description;
            this.basePrice = basePrice;
        }

        @Override
        public double getPrice() {
            return basePrice;  // Return the price for the size of the drink
        }

        public String getDescription() {
            return description;
        }
    }

    // Enum for Drink types
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
    }

    private DrinkSize size;
    private DrinkType type;

    public Drink(DrinkSize size, DrinkType type) {
        super(type.getDescription(), size.getPrice());
        this.size = size;
        this.type = type;
    }

    public double getPrice() {
        return size.getPrice();  // Get the price for the drink size
    }

    public String getSizeDescription() {
        return size.getDescription();
    }

    public String getTypeDescription() {
        return type.getDescription();  // Get the description of the drink type
    }
}
