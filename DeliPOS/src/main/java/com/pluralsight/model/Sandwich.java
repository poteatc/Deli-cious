package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;
import com.pluralsight.model.*;

public class Sandwich implements Priceable {
    private Bread bread;  // Bread object with BreadType and Size
    private Drink drink;  // Drink object with DrinkType and Size
    private MeatType meatType;  // MeatType enum (no price, just description)
    private List<Topping> toppings;  // List of Topping objects (regular or premium)
    private Size sandwichSize;  // Size enum for sandwich (SMALL, MEDIUM, LARGE)

    // Constructor
    public Sandwich(Bread bread, Drink drink, MeatType meatType, Size sandwichSize) {
        this.bread = bread;
        this.drink = drink;
        this.meatType = meatType;
        this.sandwichSize = sandwichSize;
        this.toppings = new ArrayList<>();
    }

    // Method to add toppings to the sandwich
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Method to remove toppings from the sandwich
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    @Override
    public double getPrice() {
        double price = 0.0;

        // Add the price of the bread (bread size and bread type affect price)
        price += bread.getPrice();

        // Add the price of the drink (drink size and drink type affect price)
        price += drink.getPrice();

        // Add the price of each topping (premium toppings cost more)
        for (Topping topping : toppings) {
            price += topping.getPrice();
        }

        // Add the price based on sandwich size (SMALL, MEDIUM, LARGE)
        price += sandwichSize.getPrice(); // The price for the sandwich size

        // Return the total price of the sandwich
        return price;
    }

    // Getter for MeatType description (just returns the description from MeatType)
    public String getMeatDescription() {
        return meatType.getDescription();  // Returns the description of the meat type (e.g., "Chicken")
    }

    // Getter for BreadType description (returns the description from BreadType)
    public String getBreadDescription() {
        return bread.getBreadType().getDescription();  // Returns description from BreadType
    }

    // Getter for DrinkType description (returns the description from DrinkType)
    public String getDrinkDescription() {
        return drink.getDrinkType().getDescription();  // Returns description from DrinkType
    }

    // Getter for the sandwich size description (e.g., "4''", "8''", "12''")
    public String getSizeDescription() {
        return sandwichSize.getDescription();  // Returns the size description
    }
}
