package com.pluralsight.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class OrderPanel extends JPanel {
    private static boolean isLastItemMainDish = false;
    private static JTextArea orderDetails;
    private static ArrayList<String> orderItems = new ArrayList<>();

    public OrderPanel() {
        setLayout(new BorderLayout());
        orderDetails = new JTextArea();
        orderDetails.setEditable(false);

        add(new JScrollPane(orderDetails), BorderLayout.CENTER);
        updateOrderDetails();
    }

    public static void addOrderItem(String item, double price) {
        if (isLastItemMainDish) {
            orderItems.add("    + " + item + " - $" + price); // Indented for subitem
        } else {
            orderItems.add(item + " - $" + price);
            isLastItemMainDish = item.equals("Sandwich"); // Set flag if main dish
        }
        updateOrderDetails();
        TotalPanel.updateTotal(price);
    }

    private static void updateOrderDetails() {
        orderDetails.setText(String.join("\n", orderItems));
    }

    public static void removeLastOrderItem() {
        if (!orderItems.isEmpty()) {
            // Remove last item and update total
            orderItems.remove(orderItems.size() - 1);
            updateOrderDetails();
            TotalPanel.updateTotal(-10); // Subtract price from total
        }
    }

    public static void clearOrder() {
        orderItems.clear();
        updateOrderDetails();
    }



}
