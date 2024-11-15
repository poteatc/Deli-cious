package com.pluralsight.controller;

import com.pluralsight.view.*;
import java.util.Scanner;

public class AppController {

    public static void main(String[] args) {
        AppController program = new AppController();
        program.start();
    }

    private final Scanner scanner;
    private final HomeScreen homeScreen;
    private final OrderController orderController;


    // Constructor to initialize the screens and scanner
    public AppController() {
        scanner = new Scanner(System.in);
        homeScreen = new HomeScreen();
        orderController = new OrderController();
    }

    // Main method to start the app
    public void start() {
        boolean running = true;

        while (running) {
            // Display Home Screen
            homeScreen.display();
            int choice = homeScreen.getSelection(scanner);  // Get user's selection

            switch (choice) {
                case 1 -> orderController.startNewOrder();  // If "New Order", go to order process
                case 2 -> orderController.viewOrders();
                case 3 -> orderController.removeOrder();
                case 4 -> orderController.checkout();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;  // Exit the loop and end the app
                }
                default -> System.out.println("Invalid selection. Please choose again.");
            }
        }
    }

}

