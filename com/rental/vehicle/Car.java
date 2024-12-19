package com.rental.vehicle;

public class Car extends Vehicle {
    public Car(String vehicleId, String model, double baseRentalRate, boolean isAvailable) {
        super(vehicleId, model, baseRentalRate, isAvailable);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getBaseRentalRate() * days * 1.1; // Cars have a 10% additional cost
    }

    @Override
    public String getSpecialFeatures() {
        return "Air Conditioning, Music System";
    }
}