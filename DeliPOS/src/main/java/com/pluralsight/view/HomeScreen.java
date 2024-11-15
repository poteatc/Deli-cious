package com.pluralsight.view;

import java.util.Scanner;

public class HomeScreen implements Screen {

    // Displays the welcome message and logo for the Deli
    @Override
    public void display() {
        System.out.println("""
                
                  /-------------------------------\\
                 /                                 \\
                /___________________________________\\
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                
                  Welcome to Caleb's DELI-cious subs!
                
                ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                \\----------------------------------/
                 \\                                /
                  \\______________________________/
                
                """);
    }

    // Displays the main menu options for the user
    private void showOptions() {
        System.out.println("""
                1) New Order
                2) View Orders
                3) Remove Order
                4) Checkout
                0) Exit
                """);
    }

    // Handles the user input for menu selection and validates it
    public int getSelection(Scanner scanner) {
        while (true) {
            showOptions();  // Display the available options
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();  // Read input from user

            try {
                int choice = Integer.parseInt(input);  // Try to convert input to an integer

                switch (choice) {
                    case 1, 2, 3, 4, 0 -> {
                        System.out.println();  // Print a blank line for spacing
                        return choice;  // Return the valid choice to continue processing
                    }
                    default -> System.out.println("\nInvalid option. Please enter 1, 2, 3, 4, or 0 to Exit...\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a number (0 - 4).\n");
            }
        }
    }
}
