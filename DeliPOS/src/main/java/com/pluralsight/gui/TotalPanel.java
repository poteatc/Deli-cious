package com.pluralsight.gui;

import javax.swing.*;
import java.awt.*;

public class TotalPanel extends JPanel {
    private static JLabel subtotalLabel = new JLabel("Subtotal: $0.00");
    private static JLabel taxLabel = new JLabel("Tax (10%): $0.00");
    private static JLabel totalLabel = new JLabel("Total: $0.00");
    private static double subtotal = 0.0;

    public TotalPanel() {
        setLayout(new GridLayout(3, 1));
        add(subtotalLabel);
        add(taxLabel);
        add(totalLabel);
    }

    public static void updateTotal(double price) {
        subtotal += price;
        double tax = subtotal * 0.10;
        double total = subtotal + tax;

        subtotalLabel.setText("Subtotal: $" + String.format("%.2f", subtotal));
        taxLabel.setText("Tax (10%): $" + String.format("%.2f", tax));
        totalLabel.setText("Total: $" + String.format("%.2f", total));
    }

    public static void resetTotal() {
        subtotal = 0.0;
        updateTotal(0.0);
    }
}
