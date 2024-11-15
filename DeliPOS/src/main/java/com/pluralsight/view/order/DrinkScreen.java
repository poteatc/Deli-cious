package com.pluralsight.view.order;

import com.pluralsight.model.enums.DrinkType;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class DrinkScreen implements Screen {
    @Override
    public void display() {
        System.out.print("""
                Select Drink:
                ----------------
                """);
        showOptions();
    }

    // Want to make all options generalized like this DrinkScreen showOptions() so I only need to add to the Drinks enums to update the menu
    private void showOptions() {
        for (DrinkType type : DrinkType.values()) {
            System.out.println((type.ordinal() + 1) + ") " + type.getDescription());
        }
        System.out.println("0) Return");
    }

    public int getSelection(Scanner scanner) {
        int choice = -1;

        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
                if (choice == 0) {
                    System.out.println("Returning to Order Screen...");
                }
                DrinkType selectedDrinkType = DrinkType.TEA;
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
