package com.pluralsight.view.order;

import com.pluralsight.model.enums.ChipType;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class ChipsScreen implements Screen {

    // Display the initial prompt for selecting chips
    @Override
    public void display() {
        System.out.print("""
                ----------------
                  Select Chips:
                ----------------
                """);
        showOptions();  // Show the available chip options
    }

    // Show the available chip types to the user
    private void showOptions() {
        // Loop through all ChipTypes except NONE and display them as options
        for (ChipType type : ChipType.values()) {
            if (type != ChipType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None"); // Option for no chip selection
    }

    // Get the user's chip selection
    public ChipType getSelection(Scanner scanner) {
        while (true) {
            display(); // Display chip options
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);  // Parse user input to an integer
                ChipType selectedChip = ChipType.fromChoice(choice); // Get ChipType by the choice number

                // If the choice is invalid, ask the user to try again
                if (selectedChip == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from 0 to " + ChipType.values().length + "\n.");
                    continue;
                }

                // Validate if the selected chip type is valid
                switch (selectedChip) {
                    case NONE, DORITOS, LAYS, SUN_CHIPS -> {
                        System.out.println("\n" + selectedChip.getDescription() + " selected.");
                        System.out.println("\nReturning to Order Menu...\n");
                        return selectedChip; // Valid choice, return it
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input!!! Please enter a valid number.\n"); // Handle invalid input (non-number entries)
            }
        }
    }
}
