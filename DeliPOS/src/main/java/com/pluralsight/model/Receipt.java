package com.pluralsight.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final double paymentAmount; // The amount paid by the customer
    private final double totalPrice; // The total price of all orders
    private final List<Order> orders; // List of orders in the receipt
    private final LocalDateTime localDateTime; // Timestamp for when the receipt is generated

    // Default constructor to initialize fields
    public Receipt() {
        this.orders = new ArrayList<>();
        this.localDateTime = LocalDateTime.now();
        this.paymentAmount = 0.0;
        this.totalPrice = 0.0;
    }

    // Constructor to initialize fields with given orders and payment amount
    public Receipt(List<Order> orders, double paymentAmount) {
        this.orders = orders;
        this.localDateTime = LocalDateTime.now();
        this.paymentAmount = paymentAmount;
        this.totalPrice = orders.stream().mapToDouble(Order::getPrice).sum(); // Calculate total price of orders
    }

    // Add an order to the receipt
    public void addOrder(Order order) {
        orders.add(order);
    }

    // Print the receipt details to the console
    public void printToConsole() {
        if (orders.isEmpty()) { // Check if there are no orders
            System.out.println("No orders confirmed...\n\n");
        } else {
            System.out.print("""
                    \n~~~~~~~~~~~~~~~~~~~~~~
                    """);
            int orderNumber = 1;
            for (Order o: orders) { // Print each order in the receipt
                System.out.printf("Order #: %d\n-----------------------\n", orderNumber++);
                System.out.println(o.toString());
            }
            System.out.println("""
        ~~~~~~~~~~~~~~~~~~~~~~
        ~~~~~~~~~~~~~~~~~~~~~~
        """);
        }

        // Print payment and total price details
        System.out.printf(">>>Payment amount: $%.2f\n", paymentAmount);
        System.out.printf(">>>Total price: $%.2f \n", totalPrice);
        System.out.printf(">>>Change owed: $%.2f\n\n\n", (paymentAmount - totalPrice));
    }

    // Print the receipt details to a file
    public void printToReceiptFile() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss"); // Format timestamp
        String formattedLocalDateTime = localDateTime.format(dtf);
        // Define file path for saving receipt
        String filePath = "DeliPOS/src/main/resources/receipts/" + formattedLocalDateTime + ".txt";

        try {
            FileWriter fw = new FileWriter(filePath); // Create a FileWriter
            BufferedWriter bw = new BufferedWriter(fw); // Use BufferedWriter for efficient writing

            int orderNumber = 1;
            for (Order o : orders) { // Write each order to the file
                bw.write("[" + orderNumber++ + "]\n" + o.toString() +"\n");
            }

            // Write payment details to the file
            bw.write(String.format(">>>Total price: $%.2f \n", totalPrice));
            bw.write(String.format(">>>Payment amount: $%.2f\n", paymentAmount));
            bw.write(String.format(">>>Change owed: $%.2f\n\n\n", (paymentAmount - totalPrice)));

            bw.close(); // Close BufferedWriter
        } catch (IOException e) { // Handle any file write errors
            System.out.println("Couldn't write to file...");
            throw new RuntimeException(e);  // Handle any issues during writing
        }
    }
}
