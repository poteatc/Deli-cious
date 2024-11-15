package com.pluralsight.view.order;

import com.pluralsight.model.*;
import com.pluralsight.model.enums.*;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class SandwichScreen implements Screen {
    BreadScreen breadScreen = new BreadScreen();
    ToppingScreen toppingScreen = new ToppingScreen();
    Sandwich sandwich = new Sandwich();

    @Override
    public void display() {
        System.out.println("""
                 \n
                 /-----------------------\\
                /                         \\
                ---------------------------
                  Sandwich Customization:
                ---------------------------
                \\                        /
                 \\----------------------/
                
                1) Select Bread
                2) Select Size
                3) Add Topping
                4) Toast
                5) Review
                6) Add to Order
                0) Cancel
                """);
    }

    public BreadType selectBreadType(Scanner scanner) {
        breadScreen.display();
        BreadType breadType = breadScreen.getBreadTypeSelection(scanner);
        sandwich.setBreadType(breadType);
        return breadType;
    }

    private void showSandwichSizeOptions() {
        System.out.print("""
                ---------------------
                Select Sandwich Size:
                ---------------------
                """);
        for (SandwichSize type : SandwichSize.values()) {
            if (type != SandwichSize.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None");
    }

    public SandwichSize selectSandwichSize(Scanner scanner) {
        int choice = -1;
        boolean selecting = true;

        while (selecting) {
            showSandwichSizeOptions();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
                SandwichSize selectedSize = SandwichSize.fromChoice(choice);
                if (selectedSize == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from 0 to 3.\n");
                    continue;
                }
                switch (selectedSize) {
                    case NONE, SMALL, MEDIUM, LARGE -> {
                        System.out.println("\n" + selectedSize.getDescription() + " selected.\n");
                        if (selectedSize == SandwichSize.NONE) {
                            System.out.println("\n(Error): Sandwich much have a bread size. Please select one...\n");
                            continue;
                        }
                        return selectedSize; // Valid choice, exit loop by returning choice
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
        return SandwichSize.NONE;
    }

    public Topping addTopping(Scanner scanner) {
        boolean isAddingToppings = true;
        Topping topping = null;
        while (isAddingToppings) {
            toppingScreen.display();
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);
                switch (choice) {
                    case 1 -> {
                        MeatType meatType = toppingScreen.selectMeat(scanner);
                        if (meatType != MeatType.NONE) {
                            boolean hasExtra = toppingScreen.selectHasExtra(scanner);
                            topping = new Meat(sandwich.getSandwichSize(), meatType, hasExtra);
                            sandwich.addTopping(topping);
                            isAddingToppings = false;
                        }
                    }
                    case 2 -> {
                        CheeseType cheeseType = toppingScreen.selectCheese(scanner);
                        if (cheeseType != CheeseType.NONE) {
                            boolean hasExtra = toppingScreen.selectHasExtra(scanner);
                            topping = new Cheese(sandwich.getSandwichSize(), cheeseType, hasExtra);
                            sandwich.addTopping(topping);
                            isAddingToppings = false;
                        }
                    }
                    case 3 -> {
                        RegularToppingType regularToppingType = toppingScreen.selectRegularTopping(scanner);
                        if (regularToppingType != RegularToppingType.NONE) {
                            boolean hasExtra = toppingScreen.selectHasExtra(scanner);
                            topping = new RegularTopping(sandwich.getSandwichSize(), regularToppingType, hasExtra);
                            sandwich.addTopping(topping);
                            isAddingToppings = false;
                        }
                    }
                    case 0 -> {
                        isAddingToppings = false;
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
        return topping;
    }

    public Sandwich customize(Scanner scanner) {

        int choice = -1;

        while (true) {
            display();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1 -> sandwich.setBreadType(selectBreadType(scanner));
                    case 2 -> sandwich.setSandwichSize(selectSandwichSize(scanner));
                    case 3 -> addTopping(scanner);
                    case 4 -> toggleToasted();
                    case 5 -> System.out.println(sandwich.getName());
                    case 6 -> {
                        return sandwich;
                    }
                    case 0 -> {
                        return null; // Valid choice, exit loop by returning choice
                    }
                    default -> System.out.println("\nInvalid option. Please enter a number from 0 to 6.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
    }

    public void toggleToasted() {
        if (sandwich.isToasted()) {
            System.out.println("\nSandwich is not toasted...");
            sandwich.setToasted(false);
        } else {
            System.out.println("\nToasted sandwich...");
            sandwich.setToasted(true);
        }
    }

    public boolean returnToOrderScreen(Scanner scanner) {
        System.out.print("\nWould you like to return to Order Menu? Enter 'y' for yes: ");
        String choice = scanner.nextLine().trim().toLowerCase();
        if (choice.equalsIgnoreCase("y")) {
            sandwich = new Sandwich();
            return true;
        } else {
            return false;
        }
    }
}
