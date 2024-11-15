package com.pluralsight.controller;

import com.pluralsight.model.*;
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
    //private final OrderScreen orderScreen;
    //private final SandwichScreen sandwichScreen;
    //private final ChipsScreen chipsScreen;
    //private final DrinkScreen drinkScreen;
    //private final CheckoutScreen checkoutScreen;

    // TODO: Put in OrderController class along with the OrderScreen
    private final OrderController orderController;
    //private final List<Order> orders;


    // Constructor to initialize the screens and scanner
    public AppController() {
        scanner = new Scanner(System.in);
        homeScreen = new HomeScreen();
        //orderScreen = new OrderScreen();
        //sandwichScreen = new SandwichScreen();
        //chipsScreen = new ChipsScreen();
       //drinkScreen = new DrinkScreen();
        //checkoutScreen = new CheckoutScreen();
        orderController = new OrderController();
        //orders = new ArrayList<>();
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

//    private void removeOrder() {
//        if (orders.isEmpty()) {
//            System.out.println("Nothing to remove. No orders confirmed...\n\n");
//        } else {
//            orderController.viewOrders();
//            System.out.print("Select an order # to remove: ");
//            int choice = -1;
//
//            String input = scanner.nextLine().trim();
//
//            try {
//                choice = Integer.parseInt(input);
//                if (choice > 0 && choice <= orders.size()) {
//                    System.out.println("\nOrder #" + choice + " successfully removed.\n");
//                    orders.remove(choice - 1);
//                } else {
//                    System.out.println("\nInvalid Order #...");
//                }
//
//            } catch (NumberFormatException e) {
//                System.out.println("\nInvalid input. Please enter a number...\n");
//            }
//        }
//    }

//    private void viewOrders() {
//        if (orders.isEmpty()) {
//            System.out.println("No orders confirmed...\n\n");
//        } else {
//            System.out.print("""
//                    \n~~~~~~~~~~~~~~~~~~~~~~
//                    """);
//            int orderNumber = 1;
//            for (Order o: orders) {
//                System.out.printf("Order #: %d\n-----------------------\n", orderNumber++);
//                System.out.println(o.toString());
//            }
//            double totalPrice = orders.stream().mapToDouble(Order::getPrice).sum();
//            System.out.printf("""
//        ~~~~~~~~~~~~~~~~~~~~~~
//        ~~~~~~~~~~~~~~~~~~~~~~
//        >>>Total price: $%.2f\n\n\n
//        """, totalPrice);
//        }
//    }

//    private void startNewOrder() {
//        boolean orderInProgress = true;
//
//        Order order = new Order();
//
//        while (orderInProgress) {
//            // Display Order Screen
//            orderScreen.display();
//            int choice = orderScreen.getSelection(scanner);
//
//            switch (choice) {
//                case 1 -> addSandwich(order);  // Add Sandwich to order
//                case 2 -> addDrink(order);  // Add Drink to order
//                case 3 -> addChips(order);  // Add Chips to order
//                // TODO: View order from OrderScreen
//                case 4 -> viewOrder(order);
//                case 5 -> {
//                    confirmOrder(order);  // Confirm order
//                    orderInProgress = false;
//                }
//                case 0 -> {
//                    System.out.println("\nOrder cancelled.");
//                    orderInProgress = false;  // Cancel the order and return to HomeScreen
//                }
//                default -> System.out.println("\nInvalid option. Please try again.");
//            }
//        }
//    }


//    private void addSandwich(Order order) {
//        boolean customizingSandwich = true;
//        while (customizingSandwich) {
//            // Logic to add a sandwich
//            Sandwich sandwich = sandwichScreen.customize(scanner);
//            if (sandwich == null) {
//                customizingSandwich = !sandwichScreen.returnToOrderScreen(scanner);
//            } else {
//                order.addProduct(sandwich);
//                System.out.println("\nCustom sandwich successfully added to order.\n");
//                customizingSandwich = false;
//            }
//        }
//    }

//    private void addDrink(Order order) {
//        boolean addingDrink = true;
//        while (addingDrink) {
//            // Logic to add a drink
//            drinkScreen.display();
//            DrinkType drinkType = drinkScreen.getDrinkTypeSelection(scanner);  // Get the user's drink selection
//            if (drinkType == DrinkType.NONE) {
//                System.out.println("Must select valid type...");
//                addingDrink = !drinkScreen.returnToOrderScreen(scanner);
//                continue;
//            }
//            DrinkSize drinkSize = drinkScreen.getDrinkSizeSelection(scanner);
//            if (drinkSize == DrinkSize.NONE) {
//                System.out.println("Must select a size...");
//                addingDrink = !drinkScreen.returnToOrderScreen(scanner);
//                continue;
//            }
//            Drink drink = new Drink(1, drinkSize, drinkType);
//            System.out.println(drink.getName());
//            order.addProduct(drink);
//            addingDrink = false;
//        }
//    }

//    private void addChips(Order order) {
//        // Logic to add chips
//        //chipsScreen.display();
//        ChipType chipType = chipsScreen.getSelection(scanner);  // Get the user's chips selection
//        if (chipType != ChipType.NONE) {
//            Chip chip = new Chip(chipType, 1);
//            System.out.println(chip.getName());
//            order.addProduct(chip);
//        }
//    }

//    private void viewOrder(Order order) {
//        if (order.getProducts().isEmpty()) {
//            System.out.println("\nNothing added to order yet..\n");
//        } else {
//            int productNumber = 1;
//            for (Product p : order.getProducts()) {
//                System.out.println("\n[" + (productNumber++) + "]:\n" + p.getName());
//            }
//            System.out.printf("""
//                    ~~~~~~~~~~~~~~~~~~~~~~
//                    Total price: $%.2f\n\n
//                    """, order.getPrice());
//        }
//        //System.out.println(order);
//    }

//    private void confirmOrder(Order order) {
//        if (order.getProducts().isEmpty()) {
//            System.out.println("(Error) Your order is empty...\n");
//        } else {
//            orders.add(order);
//            System.out.println("\n Order added successfully! \n");
//        }
//    }

//    private void checkout() {
//        //double totalPrice = orders.stream().mapToDouble(Order::getPrice).sum();
//        if (orders.isEmpty()) {
//            System.out.println("Can't checkout. No orders confirmed...\n\n");
//            return;
//        }
//        boolean checkingOut = true;
//        while (checkingOut) {
//            // Logic to checkout and display order details
//            checkoutScreen.display();
//            int choice = checkoutScreen.getSelection(scanner);  // Get the user's checkout confirmation or cancellation
//            if (choice == 1) {
//                double paymentAmount = checkoutScreen.getPayment(scanner);
//                if (paymentAmount < orders.stream().mapToDouble(Order::getPrice).sum()) {
//                    System.out.println("Not enough money to complete payment. Returning to checkout...\n");
//                    continue;
//                }
//                if (!(paymentAmount == -99)) {
//                    checkingOut = checkoutScreen.confirmPurchase(scanner);
//                    if (checkingOut) {
//                        checkoutScreen.printReceipt(orders, paymentAmount);
//                        orders.removeAll(orders);
//                        checkingOut = false;
//                    }
//                }
//            }
//        }
//
//    }

}

