package com.pluralsight.controller;

import com.pluralsight.model.*;
import com.pluralsight.model.enums.*;

public class Main {
    public static void main(String[] args) {
        // Should chips have a quantity? Or get quantity from list of Chips in Order

        Drink drink = new Drink(1, DrinkSize.LARGE, DrinkType.TEA);
        System.out.printf("%d %s %s(s) cost(s): %.2f\n", drink.getQuantity(), drink.getSize(), drink.getName(), drink.getPrice());

        Topping t = new RegularTopping(SandwichSize.SMALL, RegularToppingType.LETTUCE, true);
        System.out.printf("%s cost(s): %.2f\n", t, t.getPrice());

        Topping smallMeat = new Meat(SandwichSize.SMALL, MeatType.ROAST_BEEF, false);
        System.out.println(smallMeat);

        Topping smallCheeseWithExtra = new Cheese(SandwichSize.SMALL, CheeseType.PROVOLONE, true);
        System.out.println(smallCheeseWithExtra);

        Sandwich sandwich = new Sandwich(1, new Bread(BreadType.WHEAT, SandwichSize.SMALL));
        sandwich.addTopping(t);
        sandwich.addTopping(smallMeat);
        sandwich.addTopping(smallCheeseWithExtra);
        System.out.println(sandwich.getName() + "\n" + sandwich.getPrice());

        Order order = new Order();
        order.addProduct(sandwich);
        order.addProduct(drink);
        System.out.println(order.getPrice());

        Receipt receipt = new Receipt();
        receipt.addOrder(order);
        receipt.printToReceiptFile();
    }


}
