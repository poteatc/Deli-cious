package com.pluralsight.model;

public abstract class Topping implements Priceable {
    protected String name;

    public Topping(String name) {
        this.name = name;}

    public String getName() {
        return name;
    }
}