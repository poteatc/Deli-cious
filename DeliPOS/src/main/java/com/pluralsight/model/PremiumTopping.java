package com.pluralsight.model;

import com.pluralsight.model.enums.SandwichSize;


public abstract class PremiumTopping extends Topping {
    // Constructor
    public PremiumTopping(String name) {
        super(name);
    }

    // Abstract methods for getting prices specific to each topping
    protected abstract double getBasePriceBySize(SandwichSize sandwichSize);

    protected abstract double getBasePriceBySize();

    protected abstract double getUpchargeBySize();

}
