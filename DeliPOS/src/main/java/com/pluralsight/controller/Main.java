package com.pluralsight.controller;

import com.pluralsight.model.*;
import com.pluralsight.model.enums.ChipType;
import com.pluralsight.model.enums.RegularToppingType;
import com.pluralsight.model.enums.SandwichSize;

public class Main {
    public static void main(String[] args) {
        // Should chips have a quantity? Or get quantity from list of Chips in Order
        //Chip chip1 = new Chip(ChipType.DORITOS, 1);
        //System.out.printf("%d %s cost(s): %.2f\n", chip1.getQuantity(), chip1.getName(), chip1.getPrice());

        //Drink drink = new Drink(1, Drink.Size.LARGE, Drink.Type.TEA);
        //Drink drink1 = new Drink(3, Drink.Size.MEDIUM, Drink.Type.COLA);
        //System.out.printf("%d %s %s(s) cost(s): %.2f\n", drink.getQuantity(), drink.getSize(), drink.getName(), drink.getPrice());
        //System.out.printf("%d %s %s(s) cost(s): %.2f\n", drink1.getQuantity(), drink1.getSize(), drink1.getName(), drink1.getPrice());
        //printProductQuantityAndPrice(drink);
        //printProductQuantityAndPrice(drink1);
        Topping t = new RegularTopping(SandwichSize.SMALL, RegularToppingType.LETTUCE, true);
        System.out.printf("%s cost(s): %.2f\n", t, t.getPrice());

        Topping t1 = new RegularTopping(SandwichSize.MEDIUM, RegularToppingType.GUACAMOLE, false);
        System.out.printf("%s cost(s): %.2f\n", t1, t1.getPrice());

    }

    private static void printProductQuantityAndPrice(Product p) {
        if (p instanceof Chip) {
            System.out.printf("%d %s(s) cost(s): %.2f\n", p.getQuantity(), p.getName(), p.getPrice());
        }
    }
}
