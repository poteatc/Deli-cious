package com.pluralsight.view.order;

import com.pluralsight.model.Drink;
import com.pluralsight.model.enums.BreadType;
import com.pluralsight.model.enums.ChipType;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class BreadScreen implements Screen {

    // Want to make all options generalized like this DrinkScreen showOptions() so I only need to add to the Drinks enums to update the menu
    @Override
    public void display() {
        System.out.print("""
                Bread Type:
                -----------------------
                """);
        showOptions();
    }

    // Want to make all options generalized like this DrinkScreen showOptions() so I only need to add to the Drinks enums to update the menu
    private void showOptions() {
        for (BreadType type : BreadType.values()) {
            System.out.println((type.ordinal() + 1) + ") " + type.getDescription());
        }
        System.out.println("0) Return");
    }

    public BreadType getSelection(Scanner scanner) {
        int choice = -1;

        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
                if (choice == 0) {
                    System.out.println("Returning to Sandwich Screen...");
                    return null;
                }
                BreadType selectedBreadType = BreadType.fromChoice(choice);
                if (selectedBreadType != null) {
                    switch (selectedBreadType) {
                        case WHITE, WHEAT, RYE, WRAP, TORTILLA -> {
                            return selectedBreadType; // Valid choice, exit loop by returning choice
                        }
                        default -> System.out.println("Invalid option. Please enter a number from 0 to 7.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!!! Please enter a valid number.");
            }
            System.out.println("Invalid option!!! Please enter a number from 0 to 5.");
            System.out.println("Returning to Sandwich Screen...");
            return null;
        }
    }
}
