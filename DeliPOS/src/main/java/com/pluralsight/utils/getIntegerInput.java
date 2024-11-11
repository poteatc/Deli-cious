package com.pluralsight.utils;

public class getIntegerInput {
    public static int getIntegerInput(String input) {
        int i = 0;
        try {
            i = Integer.parseInt(input);

        } catch (Exception e) {
            System.out.println("You broke it");
        }
        return i;
    }
}
