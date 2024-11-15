package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.pluralsight.model.enums.BreadType;
import com.pluralsight.model.enums.SandwichSize;

public class Sandwich extends Product implements Priceable {
    private Bread bread;  // Bread object with BreadType and Size
    private List<Topping> toppings;  // List of Topping objects (regular or premium)
    private SandwichSize sandwichSize;  // Size enum for sandwich (SMALL, MEDIUM, LARGE)
    private boolean isToasted;

    // Constructor
    public Sandwich(int quantity, Bread bread) {
        super(quantity);
        this.bread = bread;
        this.sandwichSize = bread.getSize();
        this.toppings = new ArrayList<>();
        this.isToasted = false;
    }

    public Sandwich() {
        super(1);
        this.bread = new Bread();
        this.sandwichSize = bread.getSize();
        this.toppings = new ArrayList<>();
        this.isToasted = false;
    }

    public void setBreadType(BreadType breadType) {
        this.bread.setBreadType(breadType);
    }

    public BreadType getBreadType() {
        return bread.getBreadType();
    }

    public void addBread(Bread bread) {
        this.bread = bread;
    }

    public void setSandwichSize(SandwichSize sandwichSize) {
        this.sandwichSize = sandwichSize;
        this.bread.setSize(sandwichSize);
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
        String top = "```````````````````````\n";
        String sandwichToasted = isToasted ? "*Toasted*\n" : "";
        String breadDescription = bread.getDescription() + "\n" + sandwichToasted;
        String toppingsDescription = "";
        if (toppings.isEmpty()) {
            toppingsDescription += "\t- No toppings-\n";
        } else {
            for (Topping t : toppings) {
                toppingsDescription += t + "\n";
            }
        }
        String bottom = ",,,,,,,,,,,,,,,,,,,,,,,\n";
        //sandwichDescription += meats + "\n" + cheeses + "\n" + regularToppings + "\n";
        return String.format("\n%s<--Total Sandwich Price: $%.2f-->\n%s%s%s", top, getPrice(), breadDescription, toppingsDescription, bottom);
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

    public SandwichSize getSandwichSize() {
        return sandwichSize;
    }

    public boolean isToasted() {
        return isToasted;
    }

    public void setToasted(boolean toasted) {
        isToasted = toasted;
    }
}
