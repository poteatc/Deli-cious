package com.pluralsight.model;

import com.pluralsight.model.enums.RegularToppingType;
import com.pluralsight.model.enums.SandwichSize;

public class RegularTopping extends Topping {

    private RegularToppingType regularToppingType;

    public RegularTopping(SandwichSize sandwichSize, RegularToppingType regularToppingType, boolean hasExtra) {
        super(sandwichSize, ToppingType.REGULAR, hasExtra);
        this.regularToppingType = regularToppingType;
    }

    @Override
    public String toString() {
        return "\t+ " + regularToppingType.getDescription() + ": FREE";
    }
}
