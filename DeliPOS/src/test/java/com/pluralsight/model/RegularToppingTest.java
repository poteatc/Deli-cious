package com.pluralsight.model;

import com.pluralsight.model.enums.RegularToppingType;
import com.pluralsight.model.enums.SandwichSize;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegularToppingTest {

    @Test
    void get_regular_topping_price() {
        Topping t = new RegularTopping(SandwichSize.SMALL, RegularToppingType.LETTUCE, true);
        System.out.printf("%s cost(s): %.2f\n", t, t.getPrice());
        assertEquals(0.00, t.getPrice());
    }
}