package com.pluralsight.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private final double paymentAmount;
    private final double totalPrice;
    private final List<Order> orders;
    private final LocalDateTime localDateTime;

    public Receipt() {
        this.orders = new ArrayList<>();
        this.localDateTime = LocalDateTime.now();
        this.paymentAmount = 0.0;
        this.totalPrice = 0.0;
    }

    public Receipt(List<Order> orders, double paymentAmount) {
        this.orders = orders;
        this.localDateTime = LocalDateTime.now();
        this.paymentAmount = paymentAmount;
        this.totalPrice = orders.stream().mapToDouble(Order::getPrice).sum();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printToConsole() {
        if (orders.isEmpty()) {
            System.out.println("No orders confirmed...\n\n");
        } else {
            System.out.print("""
                    \n~~~~~~~~~~~~~~~~~~~~~~
                    """);
            int orderNumber = 1;
            for (Order o: orders) {
                System.out.printf("Order #: %d\n-----------------------\n", orderNumber++);
                System.out.println(o.toString());
            }
            System.out.println("""
        ~~~~~~~~~~~~~~~~~~~~~~
        ~~~~~~~~~~~~~~~~~~~~~~
        """);
        }

        System.out.printf(">>>Payment amount: $%.2f\n", paymentAmount);
        System.out.printf(">>>Total price: $%.2f \n", totalPrice);
        System.out.printf(">>>Change owed: $%.2f\n\n\n", (paymentAmount - totalPrice));
    }

    public void printToReceiptFile() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String formattedLocalDateTime = localDateTime.format(dtf);
        //String filePath = "src/main/resources/" + formattedLocalDateTime + ".txt";
        String filePath = "DeliPOS/src/main/resources/receipts/" + formattedLocalDateTime + ".txt";
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);

            int orderNumber = 1;
            for (Order o : orders) {
                bw.write("[" + orderNumber++ + "]\n" + o.toString() +"\n");
            }

            bw.write(String.format(">>>Total price: $%.2f \n", totalPrice));
            bw.write(String.format(">>>Payment amount: $%.2f\n", paymentAmount));
            bw.write(String.format(">>>Change owed: $%.2f\n\n\n", (paymentAmount - totalPrice)));

            bw.close();
        } catch (IOException e) {
            System.out.println("Couldn't write to file...");
            throw new RuntimeException(e);  // Handle any issues during writing
        }
    }
}
