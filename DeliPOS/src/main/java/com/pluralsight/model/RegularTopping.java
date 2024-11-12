package com.pluralsight.model;

import com.pluralsight.model.enums.RegularToppingType;

public class RegularTopping extends Topping {

    // Constructor for RegularTopping
    public RegularTopping(RegularToppingType type, int quantity) {
        super(type.name());
    }

    @Override
    public double getPrice() {
        // Regular toppings have no extra cost
        return 0;
    }
}
