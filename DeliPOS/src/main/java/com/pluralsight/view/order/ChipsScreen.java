package com.pluralsight.view.order;

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
                    System.out.println("Invalid option!!! Please enter a number from 0 to 3.");
                    continue;
                }
                switch (selectedChip) {
                    case NONE, DORITOS, LAYS, SUN_CHIPS -> {
                        System.out.println(selectedChip.getDescription() + " selected.");
                        System.out.println("Returning to Order Menu...");
                        selectingChips = false;
                        return selectedChip; // Valid choice, exit loop by returning choice
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!!! Please enter a valid number.");
            }
        }
        return ChipType.NONE;
    }
}
