package com.pluralsight.view.order;

import com.pluralsight.model.Bread;
import com.pluralsight.model.Meat;
import com.pluralsight.model.Sandwich;
import com.pluralsight.model.Topping;
import com.pluralsight.model.enums.BreadType;
import com.pluralsight.model.enums.MeatType;
import com.pluralsight.model.enums.SandwichSize;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class SandwichScreen implements Screen {
    BreadScreen breadScreen = new BreadScreen();
    Sandwich sandwich = new Sandwich();
    Bread bread = new Bread();

    @Override
    public void display() {
        System.out.println("""
                Sandwich Customization:
                -----------------------
                1) Select Bread
                2) Select Size
                3) Add Meat
                4) Add Cheese
                5) Add Other Toppings
                6) Add Sauces
                7) Toast Sandwich
                0) Finish Sandwich
                """);
    }

    public BreadType selectBreadType(Scanner scanner) {
        breadScreen.display();
        BreadType breadType = breadScreen.getSelection(scanner);
        sandwich.setBreadType(breadType);
        return breadType;
    }

    private void showSandwichSizeOptions() {
        for (SandwichSize type : SandwichSize.values()) {
            System.out.println((type.ordinal() + 1) + ") " + type.getDescription());
        }
        System.out.println("0) Return");
    }

    public SandwichSize selectSandwichSize(Scanner scanner) {
        System.out.print("""
                Select Sandwich Size:
                ---------------------
                """);
        showSandwichSizeOptions();

        int choice = -1;
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
                if (choice == 0) {
                    System.out.println("Returning to Bread Type Screen");
                    selectBreadType(scanner);
                    return null;
                }
                SandwichSize selectedSandwichSize = SandwichSize.fromChoice(choice);
                if (selectedSandwichSize != null) {
                    switch (selectedSandwichSize) {
                        case SMALL, MEDIUM, LARGE -> {
                            sandwich.setSandwichSize(selectedSandwichSize);
                            return selectedSandwichSize;
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
            System.out.println("Invalid option!!! Please enter a number from 0 to 3.");
            System.out.println("Returning to Sandwich Screen...");
            return null;
        }

    }
    public void showMeatTypeOptions() {
            for (MeatType type : MeatType.values()) {
                System.out.println((type.ordinal() + 1) + ") " + type.getDescription());
            }
            System.out.println("0) Return");
    }

    public MeatType selectMeatType(Scanner scanner) {
        System.out.print("""
                Select Meat Type:
                ---------------------
                """);
        showMeatTypeOptions();

        int choice = -1;
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
                if (choice == 0) {
                    System.out.println("Returning to Sandwich Size Screen");
                    selectSandwichSize(scanner);
                    return null;
                }
                MeatType selectedMeatType = MeatType.fromChoice(choice);
                //Meat meat = new Meat(sandwich.setSandwichSize(), )
                if (selectedMeatType != null) {
                    switch (selectedMeatType) {
                        case STEAK, HAM, SALAMI -> {
                            // sandwich.addTopping(selectedMeatType);
                            boolean hasExtra = selectHasExtra(scanner);
                            Meat meat = new Meat(bread.getSize(), selectedMeatType, hasExtra);
                            sandwich.addTopping(meat);
                            return selectedMeatType;
                        }
                    }

                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            }
            System.out.println("Invalid option!!! Please enter a number from 0 to 6.");
            System.out.println("Returning to Sandwich Screen...");
            return null;
        }
    }

    private boolean selectHasExtra(Scanner scanner) {
        System.out.println("Would you like extra? Enter 'y' for yes");
        String input = scanner.nextLine().toLowerCase().trim();
        boolean wantsExtra = input.equalsIgnoreCase("y");
        return wantsExtra;
    }

    public int getSelection(Scanner scanner) {
        int choice = -1;

        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1 -> selectBreadType(scanner);
                    case 2 -> selectSandwichSize(scanner);
                    case 3, 4, 5, 6, 7, 0 -> {
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
