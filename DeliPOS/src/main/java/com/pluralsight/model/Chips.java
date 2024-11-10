package com.pluralsight.model;

public class Chips extends Product {
    private static final double CHIP_PRICE = 1.50;

    public Chips(int quantity) {
        super("Chips", CHIP_PRICE); // Chips are always the same price
    }

    @Override
    public double getPrice() {
        return CHIP_PRICE; // Chips have a fixed price
    }
}