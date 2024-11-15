package com.pluralsight.model;

import com.pluralsight.model.enums.BreadType;
import com.pluralsight.model.enums.SandwichSize;

public class Bread implements Priceable {
    private BreadType breadType;  // BreadType enum to determine type of bread
    private SandwichSize sandwichSize;

    // Constructor
    public Bread(BreadType breadType, SandwichSize sandwichSize) {
        this.breadType = breadType;
        this.sandwichSize = sandwichSize;
    }

    public Bread() {
        this.breadType = BreadType.WHITE;
        this.sandwichSize = SandwichSize.SMALL;
    }

    // Getter for BreadType
    public BreadType getBreadType() {
        return breadType;
    }

    // Setter for BreadType
    public void setBreadType(BreadType breadType) {
        this.breadType = breadType;
    }

    // Getter for Size
    public SandwichSize getSize() {
        return sandwichSize;
    }

    // Setter for Size
    public void setSize(SandwichSize size) {
        this.sandwichSize = size;
    }

    // Priceable interface method to get price based on bread size
    @Override
    public double getPrice() {
        double price = 0.0;
        // Different bread sizes have different prices (small, medium, large)
        switch (sandwichSize) {
            case SMALL -> price = 5.50; // price for SMALL bread
            case MEDIUM -> price = 7.00; // price for MEDIUM bread
            case LARGE -> price =  8.50; // price for LARGE bread
         }
         return price;
    }

    public String getDescription() {
        return String.format("\t+ %s %s: $%.2f", sandwichSize.getDescription(), breadType.getDescription(), getPrice());
    }
}
