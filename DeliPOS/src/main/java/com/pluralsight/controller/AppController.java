package com.pluralsight.controller;

import com.pluralsight.view.*;
import java.util.Scanner;

public class AppController {

    public static void main(String[] args) {
        AppController program = new AppController();
        program.start();
    }

    private final Scanner scanner; // Scanner for reading user input
    private final HomeScreen homeScreen; // Represents the main menu or home screen of the app
    private final OrderController orderController; // Handles order-related operations

    // Constructor to initialize the screens and scanner
    public AppController() {
        scanner = new Scanner(System.in);
        homeScreen = new HomeScreen();
        orderController = new OrderController();
    }

    // Main method to start the app
    public void start() {
        boolean running = true; // Keeps track of whether the application is running

        while (running) {
            // Display the Home Screen menu options
            homeScreen.display();
            int choice = homeScreen.getSelection(scanner);  // Get user's menu selection

            // Handle user's menu selection
            switch (choice) {
                case 1 -> orderController.startNewOrder();  // Start a new order process
                case 2 -> orderController.viewOrders();     // View existing orders
                case 3 -> orderController.removeOrder();    // Remove an order
                case 4 -> orderController.checkout();       // Checkout and finalize orders
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;  // Exit the loop to end the application
                }
                default -> System.out.println("Invalid selection. Please choose again."); // Handle invalid input
            }
        }
    }
}
