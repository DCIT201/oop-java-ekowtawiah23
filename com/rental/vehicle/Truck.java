package com.rental.vehicle;

public class Truck extends Vehicle {
    private double loadFactor; // Additional cost based on load capacity

    public Truck(String vehicleId, String model, double baseRentalRate, boolean isAvailable, double loadFactor) {
        super(vehicleId, model, baseRentalRate, isAvailable);
        this.loadFactor = loadFactor;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * (1 + loadFactor); // Additional cost based on load factor
    }

    @Override
    public String getSpecialFeatures() {
        return "High Load Capacity, Heavy-Duty Performance";
    }
}