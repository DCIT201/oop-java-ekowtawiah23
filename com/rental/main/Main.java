package com.rental.main;

import com.rental.vehicle.*;
import com.rental.customer.Customer;
import com.rental.agency.RentalAgency;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Create rental agency
        RentalAgency agency = new RentalAgency();

        // Create vehicles
        Vehicle car = new Car("C001", "Mercedes Benz GLE Class", 50.0, true);
        Vehicle motorcycle = new Motorcycle("M002", "Yamaha MT-07", 30.0, true);
        Vehicle truck = new Truck("T003", "Ford F-150", 100.0, true, 0.2); // Truck with load factor 20%

        // Add vehicles to the agency fleet
        agency.addVehicle(car);
        agency.addVehicle(motorcycle);
        agency.addVehicle(truck);

        // Create a customer
        Customer customer = new Customer("C001", "Ekow Tawiah");

        // Scanner for user input
        Scanner scanner = new Scanner(System.in);
        int choice;

        System.out.println("Welcome to the Vehicle Rental System!");
        System.out.println("Customer: " + customer.getName());

        do {
            System.out.println("\nChoose an option:");
            System.out.println("1. Rent a Vehicle");
            System.out.println("2. Return a Vehicle");
            System.out.println("3. View Rental History");
            System.out.println("4. Exit");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Vehicles:");
                    for (Vehicle vehicle : agency.getFleet()) {
                        if (vehicle.isAvailable()) {
                            System.out.println(vehicle.getVehicleId() + ": " + vehicle.getModel());
                        }
                    }

                    System.out.print("\nEnter Vehicle ID to rent: ");
                    String rentVehicleId = scanner.nextLine();
                    System.out.print("Enter number of rental days: ");
                    int rentalDays = scanner.nextInt();
                    scanner.nextLine(); // Consume newline character

                    agency.rentVehicle(rentVehicleId, customer, rentalDays);
                    // Calculate rental cost
                    Vehicle rentedVehicle = agency.findVehicleById(rentVehicleId);
                    if (rentedVehicle != null && !rentedVehicle.isAvailable()) {
                        double rentalCost = rentedVehicle.calculateRentalCost(rentalDays);
                        System.out.println("Rental cost for " + rentedVehicle.getModel() + " for " + rentalDays + " days: $" + rentalCost);
                    }
                    break;

                case 2:
                    System.out.print("\nEnter Vehicle ID to return: ");
                    String returnVehicleId = scanner.nextLine();
                    agency.returnVehicle(returnVehicleId);
                    break;

                case 3:
                    System.out.println("\nRental History for " + customer.getName() + ":");
                    for (String rental : customer.getRentalHistory()) {
                        System.out.println(rental);
                    }
                    break;

                case 4:
                    System.out.println("\nThank you for using the Vehicle Rental System. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}