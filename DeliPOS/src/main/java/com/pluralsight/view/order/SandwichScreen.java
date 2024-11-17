package com.pluralsight.view.order;

import com.pluralsight.model.*;
import com.pluralsight.model.enums.*;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class SandwichScreen implements Screen {
    // Dependencies for handling bread and topping selections
    BreadScreen breadScreen = new BreadScreen();
    ToppingScreen toppingScreen = new ToppingScreen();
    Scanner scanner = new Scanner(System.in);

    // Displays the main sandwich customization options
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
                4) Remove Topping
                5) Toast
                6) Review
                7) Add to Order
                0) Cancel
                """);
    }

    // Allows the user to select the type of bread for the sandwich
    public BreadType selectBreadType() {
        breadScreen.display();  // Display the bread selection screen
        BreadType breadType = breadScreen.getBreadTypeSelection(this.scanner);  // Get the user's choice for bread
        return breadType;  // Return the selected bread type
    }

    // Displays sandwich size options to the user
    private void showSandwichSizeOptions() {
        System.out.print("""
                ---------------------
                Select Sandwich Size:
                ---------------------
                """);
        // Loop through each size option (except NONE) and display it
        for (SandwichSize type : SandwichSize.values()) {
            if (type != SandwichSize.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None");  // Option to choose no size
    }

    // Allows the user to select the size of the sandwich
    public SandwichSize selectSandwichSize() {
        while (true) {
            showSandwichSizeOptions();  // Display sandwich size options
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();  // Get input from user

            try {
                int choice = Integer.parseInt(input);  // Parse the user's choice
                SandwichSize selectedSize = SandwichSize.fromChoice(choice);  // Get the corresponding SandwichSize
                if (selectedSize == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from 0 to 3.\n");
                    continue;  // If invalid, prompt again
                }
                switch (selectedSize) {
                    case NONE, SMALL, MEDIUM, LARGE -> {
                        System.out.println("\n" + selectedSize.getDescription() + " selected.");
                        if (selectedSize == SandwichSize.NONE) {
                            System.out.println("\n(Error): Sandwich must have a size. Please select one...\n");
                            continue;  // If NONE, prompt again for a valid size
                        }
                        return selectedSize;  // Return the valid sandwich size
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");  // Handle non-numeric input
            }
        }
    }

    // Allows the user to add a topping (meat, cheese, or regular) to the sandwich
    public void addTopping(Sandwich sandwich) {
        boolean isAddingToppings = true;
        Topping topping;
        while (isAddingToppings) {
            toppingScreen.display();  // Display topping selection screen
            String input = scanner.nextLine().trim();  // Get input from user

            try {
                int choice = Integer.parseInt(input);  // Parse the choice
                switch (choice) {
                    case 1 -> {
                        MeatType meatType = toppingScreen.selectMeat(scanner);  // Select a meat topping
                        if (meatType != MeatType.NONE) {
                            boolean hasExtra = toppingScreen.selectHasExtra(scanner);  // Check if extra is needed
                            topping = new Meat(sandwich.getSandwichSize(), meatType, hasExtra);  // Create a meat topping
                            sandwich.addTopping(topping);  // Add topping to sandwich
                            isAddingToppings = false;  // Exit the loop
                        }
                    }
                    case 2 -> {
                        CheeseType cheeseType = toppingScreen.selectCheese(scanner);  // Select a cheese topping
                        if (cheeseType != CheeseType.NONE) {
                            boolean hasExtra = toppingScreen.selectHasExtra(scanner);  // Check for extra cheese
                            topping = new Cheese(sandwich.getSandwichSize(), cheeseType, hasExtra);  // Create a cheese topping
                            sandwich.addTopping(topping);  // Add topping to sandwich
                            isAddingToppings = false;  // Exit the loop
                        }
                    }
                    case 3 -> {
                        RegularToppingType regularToppingType = toppingScreen.selectRegularTopping(scanner);  // Select a regular topping
                        if (regularToppingType != RegularToppingType.NONE) {
                            boolean hasExtra = toppingScreen.selectHasExtra(scanner);  // Check for extra regular topping
                            topping = new RegularTopping(sandwich.getSandwichSize(), regularToppingType, hasExtra);  // Create a regular topping
                            sandwich.addTopping(topping);  // Add topping to sandwich
                            isAddingToppings = false;  // Exit the loop
                        }
                    }
                    case 0 -> isAddingToppings = false;  // Exit if user chooses 0 (cancel adding toppings)
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");  // Handle non-numeric input
            }
        }
    }

    // Customizes the sandwich based on the user's choices
    public Sandwich customize(Sandwich sandwich) {
        while (true) {
            display();  // Display sandwich customization menu
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();  // Get input from user

            try {
                int choice = Integer.parseInt(input);  // Parse the user's choice

                switch (choice) {
                    case 1 -> sandwich.setBreadType(selectBreadType());  // Set bread type
                    case 2 -> sandwich.setSandwichSize(selectSandwichSize());  // Set sandwich size
                    case 3 -> addTopping(sandwich);  // Add topping
                    case 4 -> removeTopping(sandwich);  // Remove topping
                    case 5 -> toggleToasted(sandwich);  // Toast the sandwich
                    case 6 -> System.out.println(sandwich.getName());  // Review the sandwich
                    case 7 -> {
                        return sandwich;  // Add the sandwich to the order and return
                    }
                    case 0 -> {
                        return null;  // Cancel customization and return null
                    }
                    default -> System.out.println("\nInvalid option. Please enter a number from 0 to 7.\n");  // Handle invalid input
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");  // Handle non-numeric input
            }
        }
    }

    // Remove a topping from the sandwich
    public void removeTopping(Sandwich sandwich) {
        // Display the current toppings
        System.out.println("Current toppings on your sandwich:");
        // Check if there are toppings to display
        if (sandwich.getToppings().isEmpty()) {
            System.out.println("No toppings selected yet.");
            return;
        }

        // Display toppings with their corresponding index
        for (int i = 0; i < sandwich.getToppings().size(); i++) {
            Topping topping = sandwich.getToppings().get(i);
            System.out.println((i + 1) + ") " + topping);  // List toppings with index starting from 1
        }
        System.out.println("0) Cancel (Do not remove any topping)");

        // Ask user to select a topping to remove
        boolean isRemovingToppings = true;
        while (isRemovingToppings) {
            System.out.print("Enter the number of the topping to remove: ");
            String input = scanner.nextLine().trim();  // Get input from user

            try {
                int choice = Integer.parseInt(input);  // Parse the user's choice
                if (choice == 0) {
                    System.out.println("No topping removed.");
                    return;  // Exit if the user chooses to cancel
                }

                if (choice < 1 || choice > sandwich.getToppings().size()) {
                    System.out.println("\nInvalid option! Please enter a valid number between 1 and " + sandwich.getToppings().size() + ".");
                    continue;  // If the choice is out of bounds, prompt again
                }

                // Remove the selected topping (adjust for zero-indexed list)
                Topping toppingToRemove = sandwich.getToppings().get(choice - 1);
                sandwich.removeTopping(toppingToRemove);  // Remove the topping from the sandwich
                System.out.println(toppingToRemove + " removed from your sandwich.");
                return;  // Exit after removal

            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");  // Handle non-numeric input
            }
        }
    }


    // Toggle whether the sandwich is toasted or not
    public void toggleToasted(Sandwich sandwich) {
        if (sandwich.isToasted()) {
            System.out.println("\nSandwich is not toasted...");
            sandwich.setToasted(false);  // If toasted, make it not toasted
        } else {
            System.out.println("\nToasted sandwich...");
            sandwich.setToasted(true);  // If not toasted, make it toasted
        }
    }

    // Ask the user if they want to return to the order menu
    public boolean returnToOrderScreen(Scanner scanner) {
        System.out.print("\nWould you like to return to Order Menu? Enter 'y' for yes: ");
        String choice = scanner.nextLine().trim().toLowerCase();  // Get input and convert to lowercase
        return choice.equalsIgnoreCase("y");  // Return true if the user chooses 'y'
    }
}
