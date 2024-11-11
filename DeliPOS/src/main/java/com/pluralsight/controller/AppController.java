package com.pluralsight.controller;

import com.pluralsight.view.HomeScreen;
import com.pluralsight.view.OrderScreen;

import java.util.Scanner;

public class AppController {
    private final Scanner scanner = new Scanner(System.in);
    private boolean running = true;

    public void start() {
        while (running) {
            navigateToHomeScreen();
        }
        scanner.close(); // Close the scanner when exiting
    }

    private void navigateToHomeScreen() {
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.display();
        int selection = homeScreen.getSelection(scanner);

        switch (selection) {
            case 1 -> navigateToOrderScreen();
            case 0 -> running = false;
            default -> System.out.println("Invalid selection, please try again.");
        }
    }

    private void navigateToOrderScreen() {
        OrderScreen orderScreen = new OrderScreen();
        orderScreen.display();
        int selection = orderScreen.getSelection(scanner);

        switch (selection) {
            case 1 -> navigateToAddSandwichScreen();
            case 2 -> navigateToAddDrinkScreen();
            case 3 -> navigateToAddChipsScreen();
            case 4 -> navigateToCheckoutScreen();
            case 0 -> System.out.println("Order canceled, returning to home screen.");
            default -> System.out.println("Invalid selection, please try again.");
        }
    }

    private void navigateToAddSandwichScreen() {
        SandwichScreen sandwichScreen = new SandwichScreen();
        sandwichScreen.display(scanner);
        // Process sandwich details here, maybe collect and add to the order
    }

    private void navigateToAddDrinkScreen() {
        DrinkScreen drinkScreen = new DrinkScreen();
        drinkScreen.display(scanner);
        // Process drink details here, maybe collect and add to the order
    }

    private void navigateToAddChipsScreen() {
        ChipsScreen chipsScreen = new ChipsScreen();
        chipsScreen.display(scanner);
        // Process chips details here, maybe collect and add to the order
    }

    private void navigateToCheckoutScreen() {
        CheckoutScreen checkoutScreen = new CheckoutScreen();
        checkoutScreen.display();
        int selection = checkoutScreen.getSelection(scanner);
        if (selection == 1) {
            // Finalize order
            System.out.println("Order confirmed and receipt saved.");
        } else if (selection == 0) {
            System.out.println("Returning to home screen.");
        }
    }
}
