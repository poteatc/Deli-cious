package com.pluralsight.model;

import com.pluralsight.model.enums.CheeseType;
import com.pluralsight.model.enums.MeatType;
import com.pluralsight.model.enums.SandwichSize;

public class Cheese extends Topping {
    private CheeseType cheeseType;

    public Cheese(SandwichSize sandwichSize, CheeseType cheeseType, boolean hasExtra) {
        super(sandwichSize, Topping.ToppingType.CHEESE, hasExtra);
        this.cheeseType = cheeseType;
    }

    @Override
    public String toString() {
        String s = cheeseType.getDescription();
        s += withExtra() ? " with extra" : "";
        return String.format("\t+ %s costs: $%.2f", s, getPrice());
    }
}
