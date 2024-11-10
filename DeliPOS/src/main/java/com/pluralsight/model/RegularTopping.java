package com.pluralsight.model;

public class RegularTopping extends Topping {
    // Constructor
    public RegularTopping(String name, double price, int quantity) {
        super(name, price, quantity); // Calls Topping constructor to set name, price, and quantity
    }

    @Override
    public double getPrice() {
        return 0; // Return the fixed price for regular toppings
    }
}
