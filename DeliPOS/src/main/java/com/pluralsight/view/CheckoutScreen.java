package com.pluralsight.view;

import com.pluralsight.model.Order;
import com.pluralsight.model.Receipt;

import java.util.List;
import java.util.Scanner;

public class CheckoutScreen implements Screen {

    // Displays the main checkout screen with options
    @Override
    public void display() {
        System.out.println("""
                ----------------
                    Checkout:
                ----------------
                
                Options:
                1) Continue to Payment
                0) Cancel
                
                """);
    }

    // Gets the user's selection for whether to continue or cancel
    public int getSelection(Scanner scanner) {
        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                int choice = Integer.parseInt(input);  // Convert input to integer

                switch (choice) {
                    case 1, 0 -> {
                        return choice;  // Return the valid choice (1 for continue, 0 for cancel)
                    }
                    default -> System.out.println("\nInvalid option. Please enter 1 to Confirm or 0 to Cancel.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter 1 or 0.\n");
            }
        }
    }

    // Gets the payment amount from the user
    public double getPayment(Scanner scanner) {
        while (true) {
            System.out.print("Enter the amount of your payment or 'x' to cancel: $");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("x")) {  // User can cancel by entering 'x'
                return -99;  // Special return value to indicate cancellation
            }
            try {
                double paymentAmount = Double.parseDouble(input);  // Convert input to double
                if (paymentAmount <= 0) {  // Validate that payment is a positive amount
                    System.out.println("\nInvalid input. Please enter a positive amount...\n");
                } else {
                    return paymentAmount;  // Return the valid payment amount
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a number value for the payment (Ex. $100, $25.0)...\n");
            }
        }
    }

    // Prompts the user to confirm their purchase
    public boolean confirmPurchase(Scanner scanner) {
        System.out.print("Would you like to confirm your purchase? (Enter 'y' for yes): ");
        String input = scanner.nextLine().trim();
        return input.equalsIgnoreCase("y");  // Return true if 'y' is entered, otherwise false
    }

    // Prints the receipt to console and writes it to a file
    public void printReceipt(List<Order> orders, double paymentAmount) {
        Receipt receipt = new Receipt(orders, paymentAmount);  // Create a Receipt object
        receipt.printToConsole();  // Print the receipt to the console
        receipt.printToReceiptFile();  // Write the receipt to a file
    }
}
