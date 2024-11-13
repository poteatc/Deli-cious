package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pluralsight.model.enums.SandwichSize;

public class Sandwich extends Product implements Priceable {
    private Bread bread;  // Bread object with BreadType and Size
    private List<Topping> toppings;  // List of Topping objects (regular or premium)
    private SandwichSize sandwichSize;  // Size enum for sandwich (SMALL, MEDIUM, LARGE)

    // Constructor
    public Sandwich(int quantity, Bread bread, SandwichSize sandwichSize) {
        super(quantity);
        this.bread = bread;
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

    public String getCheeses() {
        List<Topping> cheeses = toppings.stream().filter(t -> t.getToppingType() == Topping.ToppingType.CHEESE).toList();
        return "";
    }

    public String getMeats() {
        List<Topping> meats = toppings.stream().filter(t -> t.getToppingType() == Topping.ToppingType.MEAT).toList();
        double totalPriceOfMeats = meats.stream().mapToDouble(Topping::getPrice).sum();
        String s = "Meats: \n";
        for (Topping m : meats) {
            s += m;
        }
        return s;
    }

    public String getRegularToppings() {
        return toppings.stream().filter(t -> t.getToppingType() == Topping.ToppingType.MEAT).toList().toString();
    }
    @Override
    public String getName() {
        String sandwichDescription = getBreadDescription() + " " + getSizeDescription() + "\n";
        //sandwichDescription += meats + "\n" + cheeses + "\n" + regularToppings + "\n";
        return sandwichDescription;
    }

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


    // Getter for BreadType description (returns the description from BreadType)
    public String getBreadDescription() {
        return bread.getBreadType().getDescription();  // Returns description from BreadType
    }

    // Getter for the sandwich size description (e.g., "4''", "8''", "12''")
    public String getSizeDescription() {
        return sandwichSize.getDescription();  // Returns the size description
    }
}
