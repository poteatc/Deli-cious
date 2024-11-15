package com.pluralsight.view.order;

import com.pluralsight.model.enums.BreadType;
import com.pluralsight.view.Screen;
import java.util.Scanner;

public class BreadScreen implements Screen {

    // Display the initial prompt for selecting bread
    @Override
    public void display() {
        System.out.print("""
                -------------
                Select Bread:
                -------------
                """);
    }

    // Show the available bread types to the user
    // Loops through the BreadType enum and prints each option
    private void showBreadTypeOptions() {
        System.out.print("""
                \n
                -----------------------------------
                What type of bread would you like?:
                -----------------------------------
                """);
        // Loop through all BreadTypes except NONE and display them as options
        for (BreadType type : BreadType.values()) {
            if (type != BreadType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None"); // Option for no bread selection
    }

    // Get the user's bread type selection
    public BreadType getBreadTypeSelection(Scanner scanner) {
        while (true) {
            showBreadTypeOptions(); // Display bread options
            System.out.print("\nEnter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);  // Parse user input to an integer
                BreadType selectedBreadType = BreadType.fromChoice(choice); // Get BreadType by the choice number

                // If the choice is invalid, ask the user to try again
                if (selectedBreadType == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from 0 to " + BreadType.values().length + ".\n");
                    continue;
                }

                // Validate if the selected bread type is a valid choice
                switch (selectedBreadType) {
                    case NONE, WHITE, WHEAT, RYE, WRAP, TORTILLA -> {
                        System.out.println("\n" + selectedBreadType.getDescription() + " selected.");
                        // If NONE is selected, prompt to select a valid bread type
                        if (selectedBreadType == BreadType.NONE) {
                            System.out.println("(Error): Sandwich must have a bread type. Please select one...\n");
                            continue; // Continue loop until a valid bread type is selected
                        }
                        return selectedBreadType; // Valid choice, return it
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n"); // Handle invalid input (non-number entries)
            }
        }
    }
}
