package com.pluralsight.model;

import com.pluralsight.model.enums.DrinkSize;
import com.pluralsight.model.enums.DrinkType;

public class Drink extends Product {


    private DrinkSize size;
    private DrinkType type;

    public Drink(int quantity, DrinkSize size, DrinkType type) {
        super(quantity);
        this.size = size;
        this.type = type;
    }

    @Override
    public String getName() {
        //return String.format("+%s %s %s: $%.2f", getQuantity(), getSize(), type.getDescription(), getPrice());
        return String.format("+ %s %s: $%.2f", getSize(), type.getDescription(), getPrice());
    }

    @Override
    public double getPrice() {
        return size.getPrice() * getQuantity();  // Get the price for the drink size
    }

    public String getSize() {
        return size.getDescription();
    }

    public String getType() {
        return type.getDescription();
    }
}
