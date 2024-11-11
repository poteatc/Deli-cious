package com.pluralsight.view;

import java.util.Scanner;

public class DrinkScreen implements Screen {
    @Override
    public void display() {
        System.out.println("""
                Select Drink:
                ----------------
                1) Cola (Small)
                2) Cola (Medium)
                3) Cola (Large)
                4) Water (Small)
                5) Water (Medium)
                6) Water (Large)
                0) No Drink
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
                    case 1, 2, 3, 4, 5, 6, 0 -> {
                        return choice; // Valid choice, exit loop by returning choice
                    }
                    default -> System.out.println("Invalid option. Please enter a number from 0 to 6.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }
    }
}
