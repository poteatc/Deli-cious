package com.pluralsight.view.order;

import com.pluralsight.model.enums.CheeseType;
import com.pluralsight.model.enums.MeatType;
import com.pluralsight.model.enums.RegularToppingType;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class ToppingScreen implements Screen {

    // Displays the main topping options screen
    @Override
    public void display() {
        System.out.print("""
                ----------------
                  Add Topping:
                ----------------
                1) Meats
                2) Cheeses
                3) Regular Toppings
                0) Return
                
                """);
    }

    // Displays available meat options
    private void showMeatTypeOptions() {
        System.out.print("""
                ---------------------
                  Select Meat Type:
                ---------------------
                """);
        // Loop through each MeatType and display available choices (excluding NONE)
        for (MeatType type : MeatType.values()) {
            if (type != MeatType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None\n");  // Option to not select any meat
    }

    // Handles meat selection, returns the chosen MeatType
    public MeatType selectMeat(Scanner scanner) {
        while (true) {
            showMeatTypeOptions();  // Show the list of meat options
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();  // Get input from the user

            try {
                int choice = Integer.parseInt(input);  // Convert input to integer
                MeatType selectedType = MeatType.fromChoice(choice);  // Get the MeatType from choice
                if (selectedType == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from the list.\n");
                    continue;  // If invalid, prompt again
                }
                switch (selectedType) {
                    case NONE, STEAK, HAM, SALAMI, ROAST_BEEF, CHICKEN, BACON -> {
                        System.out.println(selectedType.getDescription() + " selected.");
                        return selectedType;  // Return the valid MeatType
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
    }

    // Displays available cheese options
    private void showCheeseTypeOptions() {
        System.out.print("""
                ---------------------
                  Select Cheese Type:
                ---------------------
                """);
        // Loop through each CheeseType and display available choices (excluding NONE)
        for (CheeseType type : CheeseType.values()) {
            if (type != CheeseType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None\n");  // Option to not select any cheese
    }

    // Handles cheese selection, returns the chosen CheeseType
    public CheeseType selectCheese(Scanner scanner) {
        while (true) {
            showCheeseTypeOptions();  // Show the list of cheese options
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();  // Get input from the user

            try {
                int choice = Integer.parseInt(input);  // Convert input to integer
                CheeseType selectedType = CheeseType.fromChoice(choice);  // Get the CheeseType from choice
                if (selectedType == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from the list.\n");
                    continue;  // If invalid, prompt again
                }
                switch (selectedType) {
                    case NONE, AMERICAN, PROVOLONE, CHEDDAR, SWISS -> {
                        System.out.println(selectedType.getDescription() + " selected.");
                        return selectedType;  // Return the valid CheeseType
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
    }

    // Prompts the user to decide whether they want an extra portion of the selected topping
    public boolean selectHasExtra(Scanner scanner) {
        System.out.print("\nWould you like extra? Enter 'y' for yes: ");
        String input = scanner.nextLine().toLowerCase().trim();  // Get input from user and convert to lowercase
        return input.equalsIgnoreCase("y");  // Return true if user enters 'y'
    }

    // Displays available regular topping options
    private void showRegularToppingTypeOptions() {
        System.out.print("""
                ----------------------------
                  Select Regular Toppings:
                ----------------------------
                """);
        // Loop through each RegularToppingType and display available choices (excluding NONE)
        for (RegularToppingType type : RegularToppingType.values()) {
            if (type != RegularToppingType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None\n");  // Option to not select any regular toppings
    }

    // Handles regular topping selection, returns the chosen RegularToppingType
    public RegularToppingType selectRegularTopping(Scanner scanner) {
        boolean choosing = true;
        while (choosing) {
            showRegularToppingTypeOptions();  // Show the list of regular topping options
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();  // Get input from the user

            try {
                int choice = Integer.parseInt(input);  // Convert input to integer
                RegularToppingType selectedType = RegularToppingType.fromChoice(choice);  // Get the RegularToppingType from choice
                if (selectedType == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from the list.\n");
                    continue;  // If invalid, prompt again
                }
                switch (selectedType) {
                    case NONE, LETTUCE, PEPPERS, ONIONS, TOMATOES, JALEPENOS, CUCUMBERS, PICKLES, GUACAMOLE, MUSHROOMS
                    , MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLAND, VINAIGRETTE, AU_JUS, SAUCE -> {
                        System.out.println(selectedType.getDescription() + " selected.");
                        return selectedType;  // Return the valid RegularToppingType
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
        return RegularToppingType.NONE;  // Default return value if no valid topping is selected
    }

}
