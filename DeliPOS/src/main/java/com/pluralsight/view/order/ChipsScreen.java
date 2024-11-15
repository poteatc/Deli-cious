package com.pluralsight.view.order;

import com.pluralsight.model.enums.ChipType;
import com.pluralsight.view.Screen;

import java.util.Scanner;

public class ChipsScreen implements Screen {

    // Want to make all options generalized like this DrinkScreen showOptions() so I only need to add to the Drinks enums to update the menu
    @Override
    public void display() {
        System.out.print("""
                ----------------
                  Select Chips:
                ----------------
                """);
        showOptions();
    }

    private void showOptions() {
        for (ChipType type : ChipType.values()) {
            if (type != ChipType.NONE) {
                System.out.println((type.ordinal()) + ") " + type.getDescription());
            }
        }
        System.out.println("0) None");
    }

    public ChipType getSelection(Scanner scanner) {
        int choice = -1;
        boolean selectingChips = true;

        while (selectingChips) {
            display();
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
                ChipType selectedChip = ChipType.fromChoice(choice);
                if (selectedChip == null) {
                    System.out.println("\nInvalid option!!! Please enter a number from 0 to" + ChipType.values().length + "\n.");
                    continue;
                }
                switch (selectedChip) {
                    case NONE, DORITOS, LAYS, SUN_CHIPS -> {
                        System.out.println("\n" + selectedChip.getDescription() + " selected.\n");
                        System.out.println("\nReturning to Order Menu...\n");
                        selectingChips = false;
                        return selectedChip; // Valid choice, exit loop by returning choice
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input!!! Please enter a valid number.\n");
            }
        }
        return ChipType.NONE;
    }
}
