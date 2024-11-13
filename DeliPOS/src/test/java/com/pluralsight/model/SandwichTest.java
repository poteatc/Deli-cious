package com.pluralsight.model;

import com.pluralsight.model.enums.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SandwichTest {

    @Test
    void get_price_of_small_sandwich_with_one_regular_one_meat_one_cheese_with_extra() {
        Topping t = new RegularTopping(SandwichSize.SMALL, RegularToppingType.LETTUCE, true);
        System.out.printf("%s cost(s): %.2f\n", t, t.getPrice());

        Topping smallMeat = new Meat(SandwichSize.SMALL, MeatType.ROAST_BEEF, false);
        System.out.println(smallMeat);

        Topping smallCheeseWithExtra = new Cheese(SandwichSize.SMALL, CheeseType.PROVOLONE, true);
        System.out.println(smallCheeseWithExtra);

        Sandwich sandwich = new Sandwich(1, new Bread(BreadType.WHEAT, SandwichSize.SMALL), SandwichSize.SMALL);
        sandwich.addTopping(t);
        sandwich.addTopping(smallMeat);
        sandwich.addTopping(smallCheeseWithExtra);
        System.out.println(sandwich.getName() + "\n" + sandwich.getPrice());

        assertEquals(7.55, sandwich.getPrice());
    }
}