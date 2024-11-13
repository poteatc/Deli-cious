package com.pluralsight.model;

import com.pluralsight.model.enums.ChipType;

public class Chip extends Product {
    private static final double CHIP_PRICE = 1.50;
    //private int quantity = 0; NOW PART OF SUPERCLASS PRODUCT
    private ChipType chipType;

//    public Chip(String chipString, int quantity) {
//        super(chipString, quantity, CHIP_PRICE); // Chips are always the same price
//        this.quantity = quantity;
//        this.chipType = ChipType.valueOf(chipString);
//    }

    public Chip(ChipType chipType, int quantity) {
        super(quantity); // Chips are always the same price
        this.chipType = chipType;
    }


    @Override
    public String getName() {
        return chipType.getDescription();
    }

    @Override
    public double getPrice() {
        return CHIP_PRICE * getQuantity(); // Chips have a fixed price
    }
}