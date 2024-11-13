package com.pluralsight.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Receipt {
    private List<Order> orders;
    private LocalDateTime localDateTime;

    public Receipt() {
        this.orders = new ArrayList<>();
        this.localDateTime = LocalDateTime.now();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void printToReceiptFile() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd-hhmmss");
        String formattedLocalDateTime = localDateTime.format(dtf);
        //String filePath = "src/main/resources/" + formattedLocalDateTime + ".txt";
        String filePath = formattedLocalDateTime + ".txt";
        try {
            FileWriter fw = new FileWriter(filePath);
            BufferedWriter bw = new BufferedWriter(fw);

            for (Order o : orders) {
                bw.write(o.toString() +"\n");
            }

            bw.close();
        } catch (IOException e) {
            System.out.println("Couldn't write to file...");
            throw new RuntimeException(e);  // Handle any issues during writing
        }
    }
}
