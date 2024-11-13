package com.pluralsight.controller;

import com.pluralsight.model.Chip;
import com.pluralsight.model.enums.ChipType;

public class Main {
    public static void main(String[] args) {
        // Should chips have a quantity? Or get quantity from list of Chips in Order
        Chip chip1 = new Chip(ChipType.DORITOS, 1);
        System.out.printf("%d %s cost(s): %.2f\n", chip1.getQuantity(), chip1.getName(), chip1.getPrice());
    }
}
