package com.pluralsight.model;

public abstract class Product implements Priceable {
    //private String name;
    //private double price;
    //protected int quantity; // DOES THIS TO BE PROTECTED for subclass to access it
    // OR CAN getQuantity be private and only accessible through getter for encapsulation?
    private int quantity;

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

    // Setter for price
//    public void setPrice(double price) {
//        this.price = price;
//    }

    // This method is abstract because each Product will have a different way to calculate the price
    @Override
    public abstract double getPrice();
}
