package com.pluralsight.view;

import com.pluralsight.model.Deli;

import com.pluralsight.utils.getIntegerInput;

import java.util.Scanner;

public class UserInterface {

    private Deli deli;
    private Scanner scanner = new Scanner(System.in);

    public UserInterface() {
        this.deli = new Deli();
    }

    public void init() {
        displayHomeScreen();
    }

    private void displayHomeScreen() {
        String homeScreen = """
                HOME SCREEN
                ~~~~~~~~~~~
                1) New Order
                0) Exit
                """;
        boolean done = false;
        while (!done) {
            System.out.println(homeScreen);
            scanner = new Scanner(System.in);
            int input =  getIntegerInput.getIntegerInput(scanner.nextLine().trim().toLowerCase());
            switch (input) {
                case 1:
                    displayOrderScreen();
                    break;
                case 0:
                    System.out.println("Exiting application");
                    done = true;
                    break;
                default:
                    System.out.println("Please enter a valid number option");
                    break;
            }
        }
    }

    private void displayOrderScreen() {
        String orderScreen = """
                ORDER SCREEN
                ~~~~~~~~~~~
                1) Add Sandwich
                2) Add Drink
                3) Add Chips
                4) Checkout
                """;
        boolean done = false;
        while (!done) {
            System.out.println(orderScreen);
            scanner = new Scanner(System.in);
            int input =  getIntegerInput.getIntegerInput(scanner.nextLine().trim().toLowerCase());
            switch (input) {
                case 1:
                    displayOrderScreen();
                    break;
                case 0:
                    System.out.println("Exiting application");
                    done = true;
                    break;
                default:
                    System.out.println("Please enter a valid number option");
                    break;
            }
        }
    }
}
