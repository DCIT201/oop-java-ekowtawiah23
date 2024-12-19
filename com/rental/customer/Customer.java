package com.rental.customer;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerId;
    private String name;
    private List<String> rentalHistory;

    public Customer(String customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.rentalHistory = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public List<String> getRentalHistory() {
        return rentalHistory;
    }

    public void addRental(String vehicleId) {
        rentalHistory.add(vehicleId);
    }

    @Override
    public String toString() {
        return "Customer ID: " + customerId + ", Name: " + name + ", Rental History: " + rentalHistory;
    }
}