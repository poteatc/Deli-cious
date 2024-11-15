package com.pluralsight.controller;

import com.pluralsight.model.Order;
import com.pluralsight.model.Sandwich;
import com.pluralsight.view.order.SandwichScreen;

import java.util.Scanner;

public class SandwichController {

    private Sandwich sandwich;
    private SandwichScreen sandwichScreen;
    private Scanner scanner;

    public SandwichController() {
        this.sandwich = new Sandwich();
        this.sandwichScreen = new SandwichScreen();
        this.scanner = new Scanner(System.in);
    }

    public Sandwich getSandwich() {
        return sandwich;
    }

    public void setSandwich(Sandwich sandwich) {
        this.sandwich = sandwich;
    }

    public void startNewSandwich() {
        sandwich = new Sandwich();
        boolean customizingSandwich = true;
        while (customizingSandwich) {
            // Logic to add a sandwich
            sandwich = sandwichScreen.customize(sandwich);
            if (sandwich == null) {
                customizingSandwich = !sandwichScreen.returnToOrderScreen(scanner);
            } else {
                //.addProduct(sandwich);
                System.out.println("\nCustom sandwich successfully added to order.\n");
                customizingSandwich = false;
            }
        }
    }
}
