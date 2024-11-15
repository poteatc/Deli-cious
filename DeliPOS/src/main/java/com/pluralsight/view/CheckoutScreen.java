package com.pluralsight.view;

import com.pluralsight.model.Order;
import com.pluralsight.model.Receipt;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CheckoutScreen implements Screen {
    List<Order> orders = new ArrayList<>();
    @Override
    public void display() {
        System.out.println("""
                Checkout:
                ----------------
                Review your order:
                (Order details go here)
                
                Options:
                1) Continue to Payment
                0) Cancel
                """);
    }

    public int getSelection(Scanner scanner) {
        int choice = -1;

        while (true) {
            System.out.print("Enter your choice: ");
            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);

                switch (choice) {
                    case 1, 0 -> {
                        return choice; // Valid choice, exit loop by returning choice
                    }
                    default -> System.out.println("Invalid option. Please enter 1 to Confirm or 0 to Cancel.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter 1 or 0.");
            }
        }
    }

    public double getPayment(Scanner scanner) {
        double paymentAmount = 0.0;
        boolean paying = true;
        while (paying) {
            System.out.print("Enter the amount of your payment or 'x' to cancel: $");
            String input = scanner.nextLine().trim();
            if (input.equalsIgnoreCase("x")) {
                return -99;
            }
            try {
                paymentAmount = Double.parseDouble(input);
                if (paymentAmount <= 0) {
                    System.out.println("Invalid input. Please enter a positive amount");
                } else {
                    return paymentAmount;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number value for the payment (Ex. $100, $25.0)");
            }
        }
        return -99;
    }

    public boolean confirmPurchase(Scanner scanner) {
        System.out.println("Would you like to confirm your purchase? (Enter 'y' for yes): ");
        String input = scanner.nextLine().trim();
        return input.equalsIgnoreCase("y");
    }

    public void printReceipt(List<Order> orders, double paymentAmount) {
        Receipt receipt = new Receipt(orders, paymentAmount);
        receipt.printToConsole();
        receipt.printToReceiptFile();
    }
}
