package com.pluralsight.model;

import com.pluralsight.model.enums.ChipType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChipTest {

    @Test
    void get_price_of_one_chip() {
        Chip chip = new Chip(ChipType.DORITOS, 1);
        System.out.printf("%d %s cost(s): %.2f\n", chip.getQuantity(), chip.getName(), chip.getPrice());
    }

    @Test
    void get_price_of_two_chips() {
        Chip chip = new Chip(ChipType.SUN_CHIPS, 2);
        System.out.printf("%d %s cost(s): %.2f\n", chip.getQuantity(), chip.getName(), chip.getPrice());
    }

    @Test
    void get_price_of_ten_chips() {
        Chip chip = new Chip(ChipType.LAYS, 10);
        System.out.printf("%d %s cost(s): %.2f\n", chip.getQuantity(), chip.getName(), chip.getPrice());
    }
}