package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Deli {
    private List<Order> orders;

    public Deli() {
        orders = new ArrayList<>();
    }

    // You can add customers to the deli.
    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
