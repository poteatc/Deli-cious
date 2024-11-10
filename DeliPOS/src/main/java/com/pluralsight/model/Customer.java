package com.pluralsight.model;

import java.util.List;
import java.util.ArrayList;

public class Customer {
    List<Order> orders;

    public Customer() {
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public List<Order> getOrders() {
        return orders;
    }
}
