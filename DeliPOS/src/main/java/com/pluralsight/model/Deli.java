package com.pluralsight.model;

import java.util.ArrayList;
import java.util.List;

public class Deli {
    private List<Customer> customers;

    public Deli() {
        customers = new ArrayList<>();
    }

    // You can add customers to the deli.
    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public List<Customer> getCustomers() {
        return customers;
    }
}
