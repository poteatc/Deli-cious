package com.pluralsight.model;

import com.pluralsight.model.enums.ChipType;

public class Chip extends Product {
    private static final double CHIP_PRICE = 1.50;
    private final ChipType chipType;

    public Chip(ChipType chipType, int quantity) {
        super(quantity); // Chips are always the same price
        this.chipType = chipType;
    }


    @Override
    public String getName() {
        return String.format("+ %s: $%.2f", chipType.getDescription(), getPrice());
    }

    @Override
    public double getPrice() {
        if (chipType == ChipType.NONE) {
            return 0;
        }
        return CHIP_PRICE * getQuantity(); // Chips have a fixed price
    }
}