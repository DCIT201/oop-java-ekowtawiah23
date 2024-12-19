package com.rental.vehicle;

public class Motorcycle extends Vehicle {
    public Motorcycle(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days; // No additional cost for motorcycles
    }

    @Override
    public String getSpecialFeatures() {
        return "Lightweight, Fuel Efficient";
    }
}