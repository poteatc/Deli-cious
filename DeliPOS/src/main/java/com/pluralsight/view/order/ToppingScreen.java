package com.pluralsight.view.order;

import com.pluralsight.model.RegularTopping;
import com.pluralsight.model.enums.CheeseType;
import com.pluralsight.model.enums.MeatType;
import com.pluralsight.model.enums.RegularToppingType;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class ToppingScreen implements Screen {
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

    private void showMeatTypeOptions() {
        System.out.print("""
                ---------------------
                  Select Meat Type:
                ---------------------
                """);
        for (MeatType type : MeatType.values()) {
            if (type != MeatType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None\n");
    }

    public MeatType selectMeat(Scanner scanner) {
        boolean choosingMeatType = true;
        while (choosingMeatType) {
            showMeatTypeOptions();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                MeatType selectedType = MeatType.fromChoice(choice);
                if (selectedType == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from the list.\n");
                    continue;
                }
                switch (selectedType) {
                    case NONE, STEAK, HAM, SALAMI, ROAST_BEEF, CHICKEN, BACON -> {
                        System.out.println(selectedType.getDescription() + " selected.");
                        return selectedType; // Valid choice, exit loop by returning choice
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
        return MeatType.NONE;
    }

    private void showCheeseTypeOptions() {
        System.out.print("""
                ---------------------
                  Select Cheese Type:
                ---------------------
                """);
        for (CheeseType type : CheeseType.values()) {
            if (type != CheeseType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None\n");
    }

    public CheeseType selectCheese(Scanner scanner) {
        boolean choosing = true;
        while (choosing) {
            showCheeseTypeOptions();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                CheeseType selectedType = CheeseType.fromChoice(choice);
                if (selectedType == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from the list.\n");
                    continue;
                }
                switch (selectedType) {
                    case NONE, AMERICAN, PROVOLONE, CHEDDAR, SWISS -> {
                        System.out.println(selectedType.getDescription() + " selected.");
                        return selectedType; // Valid choice, exit loop by returning choice
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
        return CheeseType.NONE;
    }

    public boolean selectHasExtra(Scanner scanner) {
        System.out.print("\nWould you like extra? Enter 'y' for yes: ");
        String input = scanner.nextLine().toLowerCase().trim();
        boolean wantsExtra = input.equalsIgnoreCase("y");
        return wantsExtra;
    }

    private void showRegularToppingTypeOptions() {
        System.out.print("""
                ----------------------------
                  Select Regular Toppings:
                ----------------------------
                """);
        for (RegularToppingType type : RegularToppingType.values()) {
            if (type != RegularToppingType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None\n");
    }

    public RegularToppingType selectRegularTopping(Scanner scanner) {
        boolean choosing = true;
        while (choosing) {
            showRegularToppingTypeOptions();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                RegularToppingType selectedType = RegularToppingType.fromChoice(choice);
                if (selectedType == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from the list.\n");
                    continue;
                }
                switch (selectedType) {
                    case NONE, LETTUCE, PEPPERS, ONIONS, TOMATOES, JALEPENOS, CUCUMBERS, PICKLES, GUACAMOLE, MUSHROOMS
                    , MAYO, MUSTARD, KETCHUP, RANCH, THOUSAND_ISLAND, VINAIGRETTE, AU_JUS, SAUCE -> {
                        System.out.println(selectedType.getDescription() + " selected.");
                        return selectedType; // Valid choice, exit loop by returning choice
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
        return RegularToppingType.NONE;
    }

}
