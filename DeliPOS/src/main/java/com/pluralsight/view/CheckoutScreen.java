package com.pluralsight.view;

import com.pluralsight.model.Order;

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
}
