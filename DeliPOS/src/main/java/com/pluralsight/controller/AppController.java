//package com.pluralsight.controller;
//
//import com.pluralsight.model.Deli;
//import com.pluralsight.model.Drink;
//import com.pluralsight.view.*;
//import com.pluralsight.view.order.ChipsScreen;
//import com.pluralsight.view.order.DrinkScreen;
//import com.pluralsight.view.order.SandwichScreen;
//
//import java.util.Scanner;
//
//public class AppController {
//
//    public static void main(String[] args) {
//        AppController program = new AppController();
//        program.start();
//    }
//
//    private final Scanner scanner;
//    private final HomeScreen homeScreen;
//    private final OrderScreen orderScreen;
//    private final SandwichScreen sandwichScreen;
//    private final ChipsScreen chipsScreen;
//    private final DrinkScreen drinkScreen;
//    private final CheckoutScreen checkoutScreen;
//
//
//    // Constructor to initialize the screens and scanner
//    public AppController() {
//        scanner = new Scanner(System.in);
//        homeScreen = new HomeScreen();
//        orderScreen = new OrderScreen();
//        sandwichScreen = new SandwichScreen();
//        chipsScreen = new ChipsScreen();
//        drinkScreen = new DrinkScreen();
//        checkoutScreen = new CheckoutScreen();
//    }
//
//    // Main method to start the app
//    public void start() {
//        boolean running = true;
//
//        while (running) {
//            // Display Home Screen
//            homeScreen.display();
//            int choice = homeScreen.getSelection(scanner);  // Get user's selection
//
//            switch (choice) {
//                case 1 -> startNewOrder();  // If "New Order", go to order process
//                case 0 -> {
//                    System.out.println("Exiting the application. Goodbye!");
//                    running = false;  // Exit the loop and end the app
//                }
//                default -> System.out.println("Invalid selection. Please choose again.");
//            }
//        }
//    }
//
//    private void startNewOrder() {
//        boolean orderInProgress = true;
//
//        while (orderInProgress) {
//            // Display Order Screen
//            orderScreen.display();
//            int choice = orderScreen.getSelection(scanner);
//
//            switch (choice) {
//                case 1 -> addSandwich();  // Add Sandwich to order
//                case 2 -> addDrink();  // Add Drink to order
//                case 3 -> addChips();  // Add Chips to order
//                case 4 -> checkout();  // Proceed to checkout
//                case 0 -> {
//                    System.out.println("Order cancelled.");
//                    orderInProgress = false;  // Cancel the order and return to HomeScreen
//                }
//                default -> System.out.println("Invalid option. Please try again.");
//            }
//        }
//    }
//
//    private void addSandwich() {
//        // Logic to add a sandwich
//        sandwichScreen.display();
//        sandwichScreen.getSelection(scanner);  // Get the user's sandwich selection
//    }
//
//    private void addDrink() {
//        // Logic to add a drink
//        drinkScreen.display();
//        int choice = drinkScreen.getSelection(scanner);  // Get the user's drink selection
//        //Drink drink = new Drink(Drink);
//    }
//
//    private void addChips() {
//        // Logic to add chips
//        chipsScreen.display();
//        chipsScreen.getSelection(scanner);  // Get the user's chips selection
//    }
//
//    private void checkout() {
//        // Logic to checkout and display order details
//        checkoutScreen.display();
//        checkoutScreen.getSelection(scanner);  // Get the user's checkout confirmation or cancellation
//    }
//}
//
