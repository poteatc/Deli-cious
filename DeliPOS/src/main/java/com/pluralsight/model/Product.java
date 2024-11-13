package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public abstract class Product implements Priceable {
    //private String name;
    //private double price;
    //protected int quantity; // DOES THIS TO BE PROTECTED for subclass to access it
    // OR CAN getQuantity be private and only accessible through getter for encapsulation?
    private int quantity;
//    List<Chip> chips = new ArrayList<>();
//    List<Drink> drinks = new ArrayList<>();
//    List<Sandwich> sandwiches = new ArrayList<>();
//
//    public void addDrink(Drink drink) {
//        drinks.add(drink);
//    }
//    public void addChips(Chip chip) {
//        chips.add(chip);
//    }

    // Constructor
//    public Product(String name, int quantity, double price) {
//        this.name = name;
//        this.quantity = quantity;
//        this.price = price;
//    }

    // Do Products have a generic name or does it depend on subclass Type?
    public Product(int quantity) {
        this.quantity = quantity;
    }

    // Getter for name (depends on Type of Product subclass)
//    public String getName() {
//        return name;
//    }
    // Does everything Priceable have a name too?
    public abstract String getName();

    public int getQuantity() {
        return quantity;
    }

//    @Override
//    public double getPrice() {
//        double price = 0.0;
//        for (Drink p : drinks) {
//            price += p.getPrice();
//        }
//        for (Chip c: chips) {
//            price += c.getPrice();
//        }
//        for (Sandwich s :sandwiches) {
//            price += s.getPrice();
//        }
//        return price;
//    }

    // Setter for price
//    public void setPrice(double price) {
//        this.price = price;
//    }

    // This method is abstract because each Product will have a different way to calculate the price
    @Override
    public abstract double getPrice();
    // Do I need to have this if it already implements Priceable? Will need to check when calculating total price of all products in Order

}
