package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

import com.pluralsight.model.enums.BreadType;
import com.pluralsight.model.enums.SandwichSize;

public class Sandwich extends Product implements Priceable {
    private final Bread bread;  // Bread object with BreadType and Size

    private final List<Topping> toppings;  // List of Topping objects (regular or premium)
    private SandwichSize sandwichSize;  // Size enum for sandwich (SMALL, MEDIUM, LARGE)
    private boolean isToasted;  // Boolean indicating if the sandwich is toasted

    // Constructor that initializes sandwich with a specific quantity and bread
    public Sandwich(int quantity, Bread bread) {
        super(quantity);  // Calls the parent constructor to set quantity
        this.bread = bread;
        this.sandwichSize = bread.getSize();  // Sets sandwich size based on bread size
        this.toppings = new ArrayList<>();  // Initializes an empty list for toppings
        this.isToasted = false;  // Defaults to not toasted
    }

    // Default constructor that initializes sandwich with default bread and quantity 1
    public Sandwich() {
        super(1);  // Calls parent constructor with a default quantity of 1
        this.bread = new Bread();  // Uses default bread
        this.sandwichSize = bread.getSize();  // Sets sandwich size based on bread size
        this.toppings = new ArrayList<>();  // Initializes an empty list for toppings
        this.isToasted = false;  // Defaults to not toasted
    }

    // Setter for bread type
    public void setBreadType(BreadType breadType) {
        this.bread.setBreadType(breadType);
    }

    // Setter for sandwich size, also updates the bread size
    public void setSandwichSize(SandwichSize sandwichSize) {
        this.sandwichSize = sandwichSize;
        this.bread.setSize(sandwichSize);  // Updates bread size when sandwich size changes
    }

    // Method to add toppings to the sandwich
    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    // Method to remove a topping from the sandwich
    public void removeTopping(Topping topping) {
        toppings.remove(topping);
    }

    // Method to get the cheeses in the sandwich
    public List<Topping> getCheeses() {
        List<Topping> cheeses = toppings.stream().filter(t -> t.getToppingType() == Topping.ToppingType.CHEESE).toList();
        return cheeses;
    }

    // Method to get the meats in the sandwich
    public List<Topping> getMeats() {
        List<Topping> meats = toppings.stream().filter(t -> t.getToppingType() == Topping.ToppingType.MEAT).toList();
        double totalPriceOfMeats = meats.stream().mapToDouble(Topping::getPrice).sum();
        String s = "Meats: \n";
        for (Topping m : meats) {
            s += m;  // Appends each meat topping to the string
        }
        System.out.println("Total Price of Meats on this Sandwich: " + totalPriceOfMeats);
        return meats;
    }

    // Method to get the regular toppings
    public String getRegularToppings() {
        return toppings.stream().filter(t -> t.getToppingType() == Topping.ToppingType.MEAT).toList().toString();
    }

    // Method to get the name and description of the sandwich, including toppings, bread, and price
    @Override
    public String getName() {
        String top = "```````````````````````\n";
        String sandwichToasted = isToasted ? "*Toasted*\n" : "";  // Display if toasted
        String breadDescription = bread.getDescription() + "\n" + sandwichToasted;
        String toppingsDescription = "";
        if (toppings.isEmpty()) {
            toppingsDescription += "\t- No toppings-\n";  // If no toppings, display message
        } else {
            for (Topping t : toppings) {
                toppingsDescription += t + "\n";  // Adds each topping description
            }
        }
        String bottom = ",,,,,,,,,,,,,,,,,,,,,,,\n";
        return String.format("\n%s--- Total Sandwich Price: $%.2f ---\n%s%s%s", top, getPrice(), breadDescription, toppingsDescription, bottom);
    }

    // Method to calculate the total price of the sandwich, including bread and toppings
    @Override
    public double getPrice() {
        double price = 0.0;

        // Add the price of the bread (bread size and bread type affect price)
        price += bread.getPrice();

        // Add the price of each topping (premium toppings cost more)
        for (Topping topping : toppings) {
            price += topping.getPrice();
        }

        // Return the total price of the sandwich
        return price;
    }

    // Getter for sandwich size
    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    // Getter for whether the sandwich is toasted
    public boolean isToasted() {
        return isToasted;
    }

    // Setter for toasting the sandwich
    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }

    // Gets all toppings
    public List<Topping> getToppings() {
        return toppings;
    }
}
