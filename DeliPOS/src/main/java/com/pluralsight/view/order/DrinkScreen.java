package com.pluralsight.view.order;

import com.pluralsight.model.enums.DrinkSize;
import com.pluralsight.model.enums.DrinkType;
import com.pluralsight.view.Screen;
import java.util.Scanner;

public class DrinkScreen implements Screen {
    @Override
    public void display() {
        System.out.print("""
                -----------------
                | Select Drink: |
                -----------------
                """);
    }

    // Want to make all options generalized like this DrinkScreen showOptions() so I only need to add to the Drinks enums to update the menu
    private void showDrinkTypeOptions() {
        System.out.print("""
                
                What type of drink would you like?:
                
                """);
        for (DrinkType type : DrinkType.values()) {
            if (type != DrinkType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None\n");
    }


    private void showDrinkSizeOptions() {
        System.out.print("""
                
                What size would you like?:
                
                """);
        for (DrinkSize size : DrinkSize.values()) {
            if (size != DrinkSize.NONE) {
                System.out.println((size.ordinal()) + ") " + size.getDescription());
            }
        }
        System.out.println("0) None\n");
    }

    public DrinkType getDrinkTypeSelection(Scanner scanner) {
        while (true) {
            showDrinkTypeOptions();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                DrinkType selectedDrinkType = DrinkType.fromChoice(choice);
                if (selectedDrinkType == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from 0 to 3." + DrinkType.values().length + "\n");
                    continue;
                }
                switch (selectedDrinkType) {
                    case NONE, TEA, WATER, COLA -> {
                        System.out.println("\n" + selectedDrinkType.getDescription() + " selected.");
                        return selectedDrinkType; // Valid choice, exit loop by returning choice
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
    }

    public DrinkSize getDrinkSizeSelection(Scanner scanner) {
        while (true) {
            showDrinkSizeOptions();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                DrinkSize selectedDrinkSize = DrinkSize.fromChoice(choice);
                if (selectedDrinkSize == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from 0 to " + DrinkSize.values().length + "\n.");
                    continue;
                }
                switch (selectedDrinkSize) {
                    case NONE, SMALL, MEDIUM, LARGE -> {
                        System.out.println("\n" + selectedDrinkSize.getDescription() + " selected.\n");
                        return selectedDrinkSize; // Valid choice, exit loop by returning choice
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
    }

    public boolean returnToOrderScreen(Scanner scanner) {
        System.out.println("\nWould you like to return to Order Menu? Enter 'y' for yes\n");
        String choice = scanner.nextLine().trim().toLowerCase();
        return (choice.equalsIgnoreCase("y"));
    }

}
