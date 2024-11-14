package com.pluralsight.controller;

import com.pluralsight.model.Chip;
import com.pluralsight.model.Deli;
import com.pluralsight.model.Drink;
import com.pluralsight.model.enums.BreadType;
import com.pluralsight.model.enums.ChipType;
import com.pluralsight.model.enums.MeatType;
import com.pluralsight.model.enums.SandwichSize;
import com.pluralsight.view.*;
import com.pluralsight.view.order.ChipsScreen;
import com.pluralsight.view.order.DrinkScreen;
import com.pluralsight.view.order.SandwichScreen;

import java.util.Scanner;

public class AppController {

    public static void main(String[] args) {
        AppController program = new AppController();
        program.start();
    }

    private final Scanner scanner;
    private final HomeScreen homeScreen;
    private final OrderScreen orderScreen;
    private final SandwichScreen sandwichScreen;
    private final ChipsScreen chipsScreen;
    private final DrinkScreen drinkScreen;
    private final CheckoutScreen checkoutScreen;


    // Constructor to initialize the screens and scanner
    public AppController() {
        scanner = new Scanner(System.in);
        homeScreen = new HomeScreen();
        orderScreen = new OrderScreen();
        sandwichScreen = new SandwichScreen();
        chipsScreen = new ChipsScreen();
        drinkScreen = new DrinkScreen();
        checkoutScreen = new CheckoutScreen();
    }

    // Main method to start the app
    public void start() {
        boolean running = true;

        while (running) {
            // Display Home Screen
            homeScreen.display();
            int choice = homeScreen.getSelection(scanner);  // Get user's selection

            switch (choice) {
                case 1 -> startNewOrder();  // If "New Order", go to order process
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;  // Exit the loop and end the app
                }
                default -> System.out.println("Invalid selection. Please choose again.");
            }
        }
    }

    private void startNewOrder() {
        boolean orderInProgress = true;

        while (orderInProgress) {
            // Display Order Screen
            orderScreen.display();
            int choice = orderScreen.getSelection(scanner);

            switch (choice) {
                case 1 -> addSandwich();  // Add Sandwich to order
                case 2 -> addDrink();  // Add Drink to order
                case 3 -> addChips();  // Add Chips to order
                case 4 -> checkout();  // Proceed to checkout
                case 0 -> {
                    System.out.println("Order cancelled.");
                    orderInProgress = false;  // Cancel the order and return to HomeScreen
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addSandwich() {
        // Logic to add a sandwich
        sandwichScreen.display();
        BreadType breadType = sandwichScreen.selectBreadType(scanner);
        System.out.println("You selected: " + breadType.getDescription());
        //sandwichScreen.display();
        SandwichSize sandwichSize = sandwichScreen.selectSandwichSize(scanner);
        if (sandwichSize != null) {
            System.out.println("You selected: " + sandwichSize.getDescription());
        }
        MeatType meatType = sandwichScreen.selectMeatType(scanner);
        if (meatType != null) {
            System.out.println("You selected: " + meatType.getDescription());
        }


        //sandwichScreen.getSelection(scanner);  // Get the user's sandwich selection
    }

    private void addDrink() {
        // Logic to add a drink
        drinkScreen.display();
        int choice = drinkScreen.getSelection(scanner);  // Get the user's drink selection
        //Drink drink = new Drink(Drink);
    }

    private void addChips() {
        // Logic to add chips
        chipsScreen.display();
        ChipType chipType = chipsScreen.getSelection(scanner);  // Get the user's chips selection
        if (chipType != null) {
            Chip chip = new Chip(chipType, 1);
            System.out.println(chip.getName() + " : $" + chip.getPrice());
        }
    }

    private void checkout() {
        // Logic to checkout and display order details
        checkoutScreen.display();
        checkoutScreen.getSelection(scanner);  // Get the user's checkout confirmation or cancellation
    }
}

