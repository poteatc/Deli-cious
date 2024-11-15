package com.pluralsight.controller;

import com.pluralsight.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderController {
    private List<Order> orders;

    public OrderController() {
        this.orders = new ArrayList<>();
    }
}
