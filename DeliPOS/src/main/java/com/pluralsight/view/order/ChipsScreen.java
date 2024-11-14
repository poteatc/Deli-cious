package com.pluralsight.view.order;

import com.pluralsight.model.Drink;
import com.pluralsight.model.enums.ChipType;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class ChipsScreen implements Screen {

    // Want to make all options generalized like this DrinkScreen showOptions() so I only need to add to the Drinks enums to update the menu
    @Override
    public void display() {
        System.out.print("""
                Select Chips:
                ----------------
                """);
        showOptions();
    }

    private void showOptions() {
        for (ChipType type : ChipType.values()) {
            System.out.println((type.ordinal() + 1) + ") " + type.getDescription());
        }
        System.out.println("0) Return");
    }

    public ChipType getSelection(Scanner scanner) {
        int choice = -1;

        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
                if (choice == 0) {
                    System.out.println("Returning to Order Screen...");
                    return null;
                }
                ChipType selectedChip = ChipType.fromChoice(choice);
                if (selectedChip != null) {
                    switch (selectedChip) {
                        case DORITOS, LAYS, SUN_CHIPS -> {
                            return selectedChip; // Valid choice, exit loop by returning choice
                        }
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!!! Please enter a valid number.");
            }
            System.out.println("Invalid option!!! Please enter a number from 0 to 3.");
            System.out.println("Returning to Order Screen...");
            return null;
        }

    }
}
