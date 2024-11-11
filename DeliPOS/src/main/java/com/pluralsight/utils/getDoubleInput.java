package com.pluralsight.utils;

public class getDoubleInput {
    public static double getDoubleInput(String input) {
        double d = 0.0;
        try {
            d = Double.parseDouble(input);

        } catch (Exception e) {
            System.out.println("You broke it");
        }
        return d;
    }
}
