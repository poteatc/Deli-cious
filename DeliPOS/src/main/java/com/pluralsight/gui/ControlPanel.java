package com.pluralsight.gui;

import javax.swing.*;
import java.awt.*;

public class ControlPanel extends JPanel {
    public ControlPanel() {
        setLayout(new GridLayout(3, 1));

        JButton completeSaleButton = new JButton("Complete Sale");
        completeSaleButton.addActionListener(e -> completeSale());

        JButton removeItemButton = new JButton("Remove Last Item");
        removeItemButton.addActionListener(e -> removeLastItem());

        JButton clearOrderButton = new JButton("Clear Order");
        clearOrderButton.addActionListener(e -> clearOrder());

        add(completeSaleButton);
        add(removeItemButton);
        add(clearOrderButton);
    }

    private void completeSale() {
        JOptionPane.showMessageDialog(this, "Sale Completed!");
        clearOrder();
    }

    private void removeLastItem() {
        // Logic to remove the last item from the order
        OrderPanel.removeLastOrderItem();
    }

    private void clearOrder() {
        OrderPanel.clearOrder();
        TotalPanel.resetTotal();
    }
}
