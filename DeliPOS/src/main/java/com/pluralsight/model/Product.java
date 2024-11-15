package com.pluralsight.model;

public abstract class Product implements Priceable {
    //private String name;
    //private double price;
    //protected int quantity; // DOES THIS TO BE PROTECTED for subclass to access it
    // OR CAN getQuantity be private and only accessible through getter for encapsulation?
    private final int quantity;


    // Do Products have a generic name or does it depend on subclass Type?
    public Product(int quantity) {
        this.quantity = quantity;
    }

    // Does everything Priceable have a name too?
    public abstract String getName();

    public int getQuantity() {
        return quantity;
    }

    // This method is abstract because each Product will have a different way to calculate the price
    @Override
    public abstract double getPrice();
    // Do I need to have this if it already implements Priceable? Will need to check when calculating total price of all products in Order

}
