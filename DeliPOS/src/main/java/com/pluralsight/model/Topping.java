package com.pluralsight.model;

public abstract class Topping extends Product {
    private int quantity;

    // Constructor
    public Topping(String name, double price, int quantity) {
        super(name, price); // Calls Product's constructor to set name and price
        this.quantity = quantity;
    }

    // Getter for quantity
    public int getQuantity() {
        return quantity;
    }

    // Abstract method to calculate price (specific to each topping)
    @Override
    public abstract double getPrice();
}
