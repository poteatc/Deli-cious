package com.pluralsight.model;

public abstract class Product implements Priceable {
    private String name;
    private double price;

    // Constructor
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }

    // This method is abstract because each Product will have a different way to calculate the price
    @Override
    public abstract double getPrice();
}
