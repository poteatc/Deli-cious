package com.pluralsight.view;

import java.util.Scanner;

public class OrderScreen implements Screen {
    @Override
    public void display() {
        System.out.println("""
                Order Menu:
                -----------------------
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) View Order
                5) Confirm Order
                0) Cancel Order
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
                    case 1, 2, 3, 4, 5, 0 -> {
                        return choice; // Valid choice, exit loop by returning choice
                    }
                    default -> System.out.println("Invalid option. Please enter a number from 0 to 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}

