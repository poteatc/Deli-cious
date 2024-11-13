package com.pluralsight.view.order;

import com.pluralsight.view.Screen;

import java.util.Scanner;

public class BreadScreen implements Screen {

    // Want to make all options generalized like this DrinkScreen showOptions() so I only need to add to the Drinks enums to update the menu
    @Override
    public void display() {
        System.out.println("""
                Bread Type:
                -----------------------
                1) Select Bread
                2) Select Size
                3) Add Meat
                4) Add Cheese
                0) Finish Sandwich
                """);
    }

    public int getSelection(Scanner scanner) {
        int choice = -1;

        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1, 2, 3, 4, 5, 6, 7, 0 -> {
                        return choice; // Valid choice, exit loop by returning choice
                    }
                    default -> System.out.println("Invalid option. Please enter a number from 0 to 7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
