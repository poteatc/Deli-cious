package com.pluralsight.model;

import com.pluralsight.model.enums.MeatType;
import com.pluralsight.model.enums.SandwichSize;

public class Meat extends Topping {
    private final MeatType meatType;

    public Meat(SandwichSize sandwichSize, MeatType meatType, boolean hasExtra) {
        super(sandwichSize, Topping.ToppingType.MEAT, hasExtra);
        this.meatType = meatType;
    }

    @Override
    public String toString() {
        String s = meatType.getDescription();
        s += withExtra() ? " with extra" : "";
        return String.format("\t+ %s costs: $%.2f", s, getPrice());
    }
}
