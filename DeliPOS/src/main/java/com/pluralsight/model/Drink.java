package com.pluralsight.model;

public class Drink extends Product {

    // Enum for Drink sizes
    public enum Size {
        SMALL("Small", 2.00),
        MEDIUM("Medium", 2.50),
        LARGE("Large", 3.00);

        private final String description;
        private final double price;

        Size(String description, double basePrice) {
            this.description = description;
            this.price = basePrice;
        }

        public String getDescription() {
            return description;
        }

        public double getPrice() {
            return price;
        }
    }

    // Enum for Drink types
    public enum Type {
        TEA("Tea"),
        WATER("Water"),
        COLA("Cola");

        private final String description;

        Type(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }

    private Size size;
    private Type type;

    public Drink(int quantity, Size size, Type type) {
        super(quantity);
        this.size = size;
        this.type = type;
    }

    @Override
    public String getName() {
        return type.getDescription();
    }

    @Override
    public double getPrice() {
        return size.getPrice() * getQuantity();  // Get the price for the drink size
    }

    public String getSize() {
        return size.getDescription();
    }

//    public String getSizeDescription() {
//        return size.getDescription();
//    }
//
//    public String getTypeDescription() {
//        return type.getDescription();  // Get the description of the drink type
//    }
}
