package com.pluralsight.model;

import com.pluralsight.model.enums.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Test
    void get_total_order_price_of_small_sandwich_with_two_premium_toppings_and_one_large_drink() {
        Drink drink = new Drink(1, DrinkSize.LARGE, DrinkType.TEA);

        System.out.printf("%d %s %s(s) cost(s): %.2f\n", drink.getQuantity(), drink.getSize(), drink.getName(), drink.getPrice());

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

        Order order = new Order();
        order.addProduct(sandwich);
        order.addProduct(drink);
        System.out.println(order.getPrice());
        assertEquals(10.55, order.getPrice());
    }
}