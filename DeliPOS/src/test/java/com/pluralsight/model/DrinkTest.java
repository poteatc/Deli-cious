package com.pluralsight.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DrinkTest {

    @Test
    void get_price_of_one_small_drink() {
        Drink drink = new Drink(1, Drink.Size.SMALL, Drink.Type.TEA);
        printDrinkSizeQuantityAndPrice(drink);
        assertEquals(2.00, drink.getPrice());
    }

    @Test
    void get_price_of_two_small_drinks() {
        Drink drink = new Drink(2, Drink.Size.SMALL, Drink.Type.WATER);
        printDrinkSizeQuantityAndPrice(drink);
        assertEquals(4.00, drink.getPrice());
    }

    @Test
    void get_price_of_five_small_drinks() {
        Drink drink = new Drink(5, Drink.Size.SMALL, Drink.Type.COLA);
        printDrinkSizeQuantityAndPrice(drink);
        assertEquals(10.00, drink.getPrice());
    }

    @Test
    void get_price_of_one_medium_drink() {
        Drink drink = new Drink(1, Drink.Size.MEDIUM, Drink.Type.TEA);
        printDrinkSizeQuantityAndPrice(drink);
        assertEquals(2.50, drink.getPrice());
    }

    @Test
    void get_price_of_two_medium_drinks() {
        Drink drink = new Drink(2, Drink.Size.MEDIUM, Drink.Type.WATER);
        printDrinkSizeQuantityAndPrice(drink);
        assertEquals(5.00, drink.getPrice());
    }

    @Test
    void get_price_of_five_medium_drinks() {
        Drink drink = new Drink(5, Drink.Size.MEDIUM, Drink.Type.COLA);
        printDrinkSizeQuantityAndPrice(drink);
        assertEquals(12.50, drink.getPrice());
    }

    @Test
    void get_price_of_one_large_drink() {
        Drink drink = new Drink(1, Drink.Size.LARGE, Drink.Type.TEA);
        printDrinkSizeQuantityAndPrice(drink);
        assertEquals(3.00, drink.getPrice());
    }

    @Test
    void get_price_of_two_large_drinks() {
        Drink drink = new Drink(2, Drink.Size.LARGE, Drink.Type.WATER);
        printDrinkSizeQuantityAndPrice(drink);
        assertEquals(6.00, drink.getPrice());
    }

    @Test
    void get_price_of_five_large_drinks() {
        Drink drink = new Drink(5, Drink.Size.LARGE, Drink.Type.COLA);
        printDrinkSizeQuantityAndPrice(drink);
        assertEquals(15.00, drink.getPrice());
    }

    void printDrinkSizeQuantityAndPrice(Drink d) {
        System.out.printf("%d %s %s(s) cost(s): %.2f\n", d.getQuantity(), d.getSize(), d.getName(), d.getPrice());
    }
}