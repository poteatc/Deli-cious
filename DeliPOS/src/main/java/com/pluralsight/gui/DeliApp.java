package com.pluralsight.gui;

import javax.swing.*;
import java.awt.*;

public class DeliApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DeliApp::new);
    }

    public DeliApp() {
        JFrame frame = new JFrame("Deli POS System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Add different panels
        frame.add(new MenuPanel(), BorderLayout.WEST);
        frame.add(new OrderPanel(), BorderLayout.CENTER);
        frame.add(new TotalPanel(), BorderLayout.SOUTH);
        frame.add(new ControlPanel(), BorderLayout.EAST);

        frame.setVisible(true);
    }
}
