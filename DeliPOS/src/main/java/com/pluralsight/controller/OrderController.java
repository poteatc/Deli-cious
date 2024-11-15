package com.pluralsight.controller;

import com.pluralsight.model.*;
import com.pluralsight.model.enums.ChipType;
import com.pluralsight.model.enums.DrinkSize;
import com.pluralsight.model.enums.DrinkType;
import com.pluralsight.view.CheckoutScreen;
import com.pluralsight.view.OrderScreen;
import com.pluralsight.view.order.ChipsScreen;
import com.pluralsight.view.order.DrinkScreen;
import com.pluralsight.view.order.SandwichScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OrderController {
    private final List<Order> orders; // List to hold all confirmed orders
    private final OrderScreen orderScreen; // Screen for the main order menu
    private final SandwichScreen sandwichScreen; // Screen for customizing sandwiches
    private final ChipsScreen chipsScreen; // Screen for selecting chips
    private final DrinkScreen drinkScreen; // Screen for selecting drinks
    private final CheckoutScreen checkoutScreen; // Screen for handling checkout process
    private final Scanner scanner; // Scanner for user input

    public OrderController() {
        this.orders = new ArrayList<>();
        orderScreen = new OrderScreen();
        sandwichScreen = new SandwichScreen();
        chipsScreen = new ChipsScreen();
        drinkScreen = new DrinkScreen();
        checkoutScreen = new CheckoutScreen();
        scanner = new Scanner(System.in);
    }

    // Start a new order
    public void startNewOrder() {
        boolean orderInProgress = true;
        Order order = new Order(); // Create a new order instance

        while (orderInProgress) {
            // Display Order Screen
            orderScreen.display();
            int choice = orderScreen.getSelection(scanner); // Get user's menu selection for the order

            switch (choice) {
                case 1 -> addSandwich(order); // Add a sandwich to the order
                case 2 -> addDrink(order);    // Add a drink to the order
                case 3 -> addChips(order);    // Add chips to the order
                case 4 -> viewOrder(order);   // View the current order
                case 5 -> {
                    confirmOrder(order);      // Confirm the order and add it to the list of orders
                    orderInProgress = false;
                }
                case 0 -> {
                    System.out.println("\nOrder cancelled.");
                    orderInProgress = false; // Cancel the order
                }
                default -> System.out.println("\nInvalid option. Please try again."); // Handle invalid input
            }
        }
    }

    // Add the current order to the confirmed orders list
    private void confirmOrder(Order order) {
        if (order.getProducts().isEmpty()) {
            System.out.println("(Error) Your order is empty...\n");
        } else {
            orders.add(order); // Add order to the confirmed list
            System.out.println("\n Order added successfully! \n");
        }
    }

    // View the details of the current order
    private void viewOrder(Order order) {
        if (order.getProducts().isEmpty()) {
            System.out.println("\nNothing added to order yet..\n");
        } else {
            int productNumber = 1;
            for (Product p : order.getProducts()) {
                System.out.println("\n[" + (productNumber++) + "]:\n" + p.getName()); // Display each product in the order
            }
            System.out.printf("""
                    ~~~~~~~~~~~~~~~~~~~~~~
                    Total price: $%.2f
                    
                    
                    """, order.getPrice());
        }
    }

    // Add chips to the current order
    private void addChips(Order order) {
        ChipType chipType = chipsScreen.getSelection(scanner); // Get the user's chips selection
        if (chipType != ChipType.NONE) {
            Chip chip = new Chip(chipType, 1); // Create a chip product
            System.out.println(chip.getName());
            order.addProduct(chip); // Add chip to the order
        }
    }

    // Display all confirmed orders
    public void viewOrders() {
        if (orders.isEmpty()) {
            System.out.println("No orders confirmed...\n\n");
        } else {
            System.out.print("\n~~~~~~~~~~~~~~~~~~~~~~\n");
            int orderNumber = 1;
            for (Order o : orders) {
                System.out.printf("Order #: %d\n-----------------------\n", orderNumber++);
                System.out.println(o); // Display each order's details
            }
            double totalPrice = orders.stream().mapToDouble(Order::getPrice).sum(); // Calculate total price of all orders
            System.out.printf("""
                ~~~~~~~~~~~~~~~~~~~~~~
                ~~~~~~~~~~~~~~~~~~~~~~
                >>> Total price: $%.2f <<<

                
                
                """, totalPrice);
        }
    }

    // Remove an order from the confirmed orders list
    public void removeOrder() {
        if (orders.isEmpty()) {
            System.out.println("Nothing to remove. No orders confirmed...\n\n");
        } else {
            viewOrders();
            System.out.print("Select an order # to remove: ");

            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input); // Validate input as an integer
                if (choice > 0 && choice <= orders.size()) {
                    System.out.println("\nOrder #" + choice + " successfully removed.\n");
                    orders.remove(choice - 1); // Remove the selected order
                } else {
                    System.out.println("\nInvalid Order #...");
                }
            } catch (NumberFormatException e) {
                System.out.println("\nInvalid input. Please enter a number...\n");
            }
        }
    }

    // Add a customized sandwich to the current order
    private void addSandwich(Order order) {
        boolean customizingSandwich = true;
        while (customizingSandwich) {
            Sandwich sandwich = sandwichScreen.customize(new Sandwich()); // Create and customize a sandwich
            if (sandwich == null) {
                customizingSandwich = !sandwichScreen.returnToOrderScreen(scanner); // Return to the order menu
            } else {
                order.addProduct(sandwich); // Add the customized sandwich to the order
                System.out.println("\nCustom sandwich successfully added to order.\n");
                customizingSandwich = false;
            }
        }
    }

    // Add a drink to the current order
    private void addDrink(Order order) {
        boolean addingDrink = true;
        while (addingDrink) {
            drinkScreen.display(); // Display drink options
            DrinkType drinkType = drinkScreen.getDrinkTypeSelection(scanner); // Get the user's drink type selection
            if (drinkType == DrinkType.NONE) {
                System.out.println("Must select valid type...");
                addingDrink = !drinkScreen.returnToOrderScreen(scanner);
                continue;
            }
            DrinkSize drinkSize = drinkScreen.getDrinkSizeSelection(scanner); // Get the user's drink size selection
            if (drinkSize == DrinkSize.NONE) {
                System.out.println("Must select a size...");
                addingDrink = !drinkScreen.returnToOrderScreen(scanner);
                continue;
            }
            Drink drink = new Drink(1, drinkSize, drinkType); // Create the drink
            System.out.println(drink.getName());
            order.addProduct(drink); // Add the drink to the order
            addingDrink = false;
        }
    }

    // Handle the checkout process
    public void checkout() {
        if (orders.isEmpty()) {
            System.out.println("Can't checkout. No orders confirmed...\n\n");
            return;
        }
        boolean checkingOut = true;
        while (checkingOut) {
            checkoutScreen.display(); // Display checkout options
            int choice = checkoutScreen.getSelection(scanner); // Get user's checkout action
            if (choice == 1) {
                double paymentAmount = checkoutScreen.getPayment(scanner); // Process payment
                if (paymentAmount < orders.stream().mapToDouble(Order::getPrice).sum()) {
                    System.out.println("Not enough money to complete payment. Returning to checkout...\n");
                    continue;
                }
                if (paymentAmount != -99) {
                    checkingOut = checkoutScreen.confirmPurchase(scanner); // Confirm purchase
                    if (checkingOut) {
                        checkoutScreen.printReceipt(orders, paymentAmount); // Print receipt
                        orders.clear(); // Clear all confirmed orders
                        checkingOut = false;
                    }
                }
            }
        }
    }
}
