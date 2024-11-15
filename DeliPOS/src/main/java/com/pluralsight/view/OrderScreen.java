package com.pluralsight.view;

import java.util.Scanner;

public class OrderScreen implements Screen {

    // Displays the options available in the Order Menu
    @Override
    public void display() {
        System.out.println("""
               
               |-----------------------|
               |      Order Menu:      |
               |-----------------------|
               
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) View Order
                5) Confirm Order
                0) Cancel Order
               """);
    }

    // Gets the user's selection from the menu options
    public int getSelection(Scanner scanner) {
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();  // Read input from the user

            try {
                int choice = Integer.parseInt(input);  // Try to parse input as an integer

                switch (choice) {
                    case 1, 2, 3, 4, 5, 0 -> {
                        return choice;  // Valid choice, exit loop by returning the selected choice
                    }
                    default -> System.out.println("\nInvalid option. Please enter a number from 0 to 5.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
    }
}
