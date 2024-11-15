package com.pluralsight.view.order;

import com.pluralsight.model.Drink;
import com.pluralsight.model.enums.BreadType;
import com.pluralsight.model.enums.ChipType;
import com.pluralsight.model.enums.DrinkType;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class BreadScreen implements Screen {

    // Want to make all options generalized like this DrinkScreen showOptions() so I only need to add to the Drinks enums to update the menu
    @Override
    public void display() {
        System.out.print("""
                -------------
                Select Bread:
                -------------
                """);
    }

    // Want to make all options generalized like this DrinkScreen showOptions() so I only need to add to the Drinks enums to update the menu
    private void showBreadTypeOptions() {
        System.out.print("""
                \n
                -----------------------------------
                What type of bread would you like?:
                -----------------------------------
                """);
        for (BreadType type : BreadType.values()) {
            if (type != BreadType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None");
    }

    public BreadType getBreadTypeSelection(Scanner scanner) {
        int choice = -1;
        boolean selecting = true;

        while (selecting) {
            showBreadTypeOptions();
            System.out.print("\nEnter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
                BreadType selectedBreadType = BreadType.fromChoice(choice);
                if (selectedBreadType == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from 0 to " + BreadType.values().length + ".\n");
                    continue;
                }
                switch (selectedBreadType) {
                    case NONE, WHITE, WHEAT, RYE, WRAP, TORTILLA -> {
                        System.out.println("\n" + selectedBreadType.getDescription() + " selected.");
                        if (selectedBreadType == BreadType.NONE) {
                            System.out.println("(Error): Sandwich much have a bread type. Please select one...\n");
                            continue;
                        }
                        return selectedBreadType; // Valid choice, exit loop by returning choice
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a valid number.\n");
            }
        }
        return null;
    }
}
