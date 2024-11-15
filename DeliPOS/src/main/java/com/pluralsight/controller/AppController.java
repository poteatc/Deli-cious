package com.pluralsight.controller;

import com.pluralsight.model.Chip;
import com.pluralsight.model.Drink;
import com.pluralsight.model.Order;
import com.pluralsight.model.Product;
import com.pluralsight.model.enums.*;
import com.pluralsight.view.*;
import com.pluralsight.view.order.ChipsScreen;
import com.pluralsight.view.order.DrinkScreen;
import com.pluralsight.view.order.SandwichScreen;

import java.util.ArrayList;
import java.util.List;
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

    // TODO: Put in OrderController class along with the OrderScreen
    private final List<Order> orders;


    // Constructor to initialize the screens and scanner
    public AppController() {
        scanner = new Scanner(System.in);
        homeScreen = new HomeScreen();
        orderScreen = new OrderScreen();
        sandwichScreen = new SandwichScreen();
        chipsScreen = new ChipsScreen();
        drinkScreen = new DrinkScreen();
        checkoutScreen = new CheckoutScreen();
        orders = new ArrayList<>();
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
                case 2 -> viewOrders();
                // TODO: Add way to remove orders
                case 3 -> removeOrder();
                case 4 -> checkout();
                case 0 -> {
                    System.out.println("Exiting the application. Goodbye!");
                    running = false;  // Exit the loop and end the app
                }
                default -> System.out.println("Invalid selection. Please choose again.");
            }
        }
    }

    private void removeOrder() {
        if (orders.isEmpty()) {
            System.out.println("No orders confirmed...");
        } else {
            viewOrders();
            System.out.print("Select an order # to remove: ");
            int choice = -1;

            String input = scanner.nextLine().trim();

            try {
                choice = Integer.parseInt(input);
                if (choice > 0 && choice <= orders.size()) {
                    System.out.println("Order #" + choice + " successfully removed.");
                    orders.remove(choice - 1);
                } else {
                    System.out.println("\nInvalid Order #...");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number...");
            }
        }
    }

    private void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders confirmed...");
        } else {
            System.out.print("""
                    \n~~~~~~~~~~~~~~~~~~~~~~
                    """);
            int orderNumber = 1;
            for (Order o: orders) {
                System.out.printf("Order #: %d\n-----------------------\n", orderNumber++);
                System.out.println(o.toString());
            }
            double totalPrice = orders.stream().mapToDouble(Order::getPrice).sum();
            System.out.printf("""
        ~~~~~~~~~~~~~~~~~~~~~~
        ~~~~~~~~~~~~~~~~~~~~~~
        Total price: $%.2f\n\n\n
        """, totalPrice);
        }
    }

    private void startNewOrder() {
        boolean orderInProgress = true;

        Order order = new Order();

        while (orderInProgress) {
            // Display Order Screen
            orderScreen.display();
            int choice = orderScreen.getSelection(scanner);

            switch (choice) {
                case 1 -> addSandwich(order);  // Add Sandwich to order
                case 2 -> addDrink(order);  // Add Drink to order
                case 3 -> addChips(order);  // Add Chips to order
                // TODO: View order from OrderScreen
                case 4 -> viewOrder(order);
                case 5 -> {
                    confirmOrder(order);  // Confirm order
                    System.out.println("Order confirmed.");
                    orderInProgress = false;
                }
                case 0 -> {
                    System.out.println("Order cancelled.");
                    orderInProgress = false;  // Cancel the order and return to HomeScreen
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
    }


    private void addSandwich(Order order) {
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

    private void addDrink(Order order) {
        boolean addingDrink = true;
        while (addingDrink) {
            // Logic to add a drink
            drinkScreen.display();
            DrinkType drinkType = drinkScreen.getDrinkTypeSelection(scanner);  // Get the user's drink selection
            if (drinkType == DrinkType.NONE) {
                System.out.println("Must select valid type...");
                addingDrink = !drinkScreen.returnToOrderScreen(scanner);
                continue;
            }
            DrinkSize drinkSize = drinkScreen.getDrinkSizeSelection(scanner);
            if (drinkSize == DrinkSize.NONE) {
                System.out.println("Must select a size...");
                addingDrink = !drinkScreen.returnToOrderScreen(scanner);
                continue;
            }
            Drink drink = new Drink(1, drinkSize, drinkType);
            System.out.println(drink.getName());
            order.addProduct(drink);
            addingDrink = false;
        }
    }

    private void addChips(Order order) {
        // Logic to add chips
        //chipsScreen.display();
        ChipType chipType = chipsScreen.getSelection(scanner);  // Get the user's chips selection
        if (chipType != ChipType.NONE) {
            Chip chip = new Chip(chipType, 1);
            System.out.println(chip.getName());
            order.addProduct(chip);
        }
    }

    private void viewOrder(Order order) {
        if (order.getProducts().isEmpty()) {
            System.out.println("\nNothing added to order yet..\n");
        } else {
            int productNumber = 1;
            for (Product p : order.getProducts()) {
                System.out.println("[" + (productNumber++) + "] " + p.getName());
            }
            System.out.printf("""
                    ~~~~~~~~~~~~~~~~~~~~~~
                    Total price: $%.2f\n\n
                    """, order.getPrice());
        }
        //System.out.println(order);
    }

    private void confirmOrder(Order order) {
        orders.add(order);
    }

    private void checkout() {
        // Logic to checkout and display order details
        checkoutScreen.display();
        checkoutScreen.getSelection(scanner);  // Get the user's checkout confirmation or cancellation
    }

}

