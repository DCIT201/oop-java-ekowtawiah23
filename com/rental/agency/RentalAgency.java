package com.rental.agency;

import com.rental.vehicle.Vehicle;
import com.rental.customer.Customer;

import java.util.ArrayList;
import java.util.List;

public class RentalAgency {
    private List<Vehicle> fleet;

    public RentalAgency() {
        this.fleet = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        fleet.add(vehicle);
    }

    public List<Vehicle> getFleet() {
        return fleet;
    }

    public Vehicle findVehicleById(String vehicleId) {
        for (Vehicle vehicle : fleet) {
            if (vehicle.getVehicleId().equalsIgnoreCase(vehicleId)) {
                return vehicle;
            }
        }
        return null;
    }

    public void rentVehicle(String vehicleId, Customer customer, int days) {
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle != null && vehicle.isAvailable()) {
            vehicle.setAvailable(false);
            customer.addRental(vehicleId);
            System.out.println("Rental Successful! " + vehicle.getModel() + " is now rented to " + customer.getName() + ".");
        } else {
            System.out.println("Vehicle is not available for rental.");
        }
    }

    public void returnVehicle(String vehicleId) {
        Vehicle vehicle = findVehicleById(vehicleId);
        if (vehicle != null && !vehicle.isAvailable()) {
            vehicle.setAvailable(true);
            System.out.println(vehicle.getModel() + " has been successfully returned and is now available.");
        } else {
            System.out.println("Error: Vehicle is either already available or does not exist.");
        }
    }
}