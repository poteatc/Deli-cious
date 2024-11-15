package com.pluralsight.view.order;

import com.pluralsight.model.enums.DrinkSize;
import com.pluralsight.model.enums.DrinkType;
import com.pluralsight.view.Screen;
import java.util.Scanner;

public class DrinkScreen implements Screen {

    // Display the initial prompt for selecting a drink
    @Override
    public void display() {
        System.out.print("""
                -----------------
                | Select Drink: |
                -----------------
                """);
    }

    // Show available drink types for the user to choose from
    private void showDrinkTypeOptions() {
        System.out.print("""
                
                What type of drink would you like?:
                
                """);
        // Loop through all available DrinkTypes and display them as options
        for (DrinkType type : DrinkType.values()) {
            if (type != DrinkType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None\n");  // Option to choose no drink
    }

    // Show available drink sizes for the user to choose from
    private void showDrinkSizeOptions() {
        System.out.print("""
                
                What size would you like?:
                
                """);
        // Loop through all available DrinkSizes and display them as options
        for (DrinkSize size : DrinkSize.values()) {
            if (size != DrinkSize.NONE) {
                System.out.println((size.ordinal()) + ") " + size.getDescription());
            }
        }
        System.out.println("0) None\n");  // Option to choose no size
    }

    // Get the user's selected drink type
    public DrinkType getDrinkTypeSelection(Scanner scanner) {
        while (true) {
            showDrinkTypeOptions();  // Display available drink types
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();  // Read input from user

            try {
                int choice = Integer.parseInt(input);  // Convert input to integer
                DrinkType selectedDrinkType = DrinkType.fromChoice(choice);  // Get the corresponding DrinkType
                if (selectedDrinkType == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from 0 to " + DrinkType.values().length + ".\n");
                    continue;
                }
                switch (selectedDrinkType) {
                    case NONE, TEA, WATER, COLA -> {
                        System.out.println("\n" + selectedDrinkType.getDescription() + " selected.");
                        return selectedDrinkType;  // Return the selected drink type
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");  // Handle invalid input
            }
        }
    }

    // Get the user's selected drink size
    public DrinkSize getDrinkSizeSelection(Scanner scanner) {
        while (true) {
            showDrinkSizeOptions();  // Display available drink sizes
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();  // Read input from user

            try {
                int choice = Integer.parseInt(input);  // Convert input to integer
                DrinkSize selectedDrinkSize = DrinkSize.fromChoice(choice);  // Get the corresponding DrinkSize
                if (selectedDrinkSize == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from 0 to " + DrinkSize.values().length + ".\n");
                    continue;
                }
                switch (selectedDrinkSize) {
                    case NONE, SMALL, MEDIUM, LARGE -> {
                        System.out.println("\n" + selectedDrinkSize.getDescription() + " selected.\n");
                        return selectedDrinkSize;  // Return the selected drink size
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");  // Handle invalid input
            }
        }
    }

    // Ask the user if they want to return to the order menu
    public boolean returnToOrderScreen(Scanner scanner) {
        System.out.println("\nWould you like to return to Order Menu? Enter 'y' for yes\n");
        String choice = scanner.nextLine().trim().toLowerCase();  // Read input and convert to lowercase
        return (choice.equalsIgnoreCase("y"));  // Return true if the user wants to return to the order menu
    }
}
