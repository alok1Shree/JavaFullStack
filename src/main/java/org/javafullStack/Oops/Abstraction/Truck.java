package org.javafullStack.Oops.Abstraction;

public class Truck extends Vehicle {

    private double loadCapacity;
    private int axles;

    public Truck(String brand, String model, int year, double loadCapacity, int axles) {
        super(brand, model, year);
        this.loadCapacity = loadCapacity;
        this.axles = axles;
    }

    @Override
    public void start() {
        System.out.println("🚛 " + getBrand() + " Truck — diesel engine ROARS. 💨");
        System.out.println("   Load capacity: " + loadCapacity + " tonnes");
        System.out.println("   Axles: " + axles);
    }

    @Override
    public void stop() {
        System.out.println("🚛 " + getBrand() + " Truck — air brakes engaged. 🛑");
    }

    @Override
    public double calculateFuelCost(double distance) {
        double DIESEL_PRICE = 95.0;
        double MILEAGE = 5.0;
        return (distance/MILEAGE) * DIESEL_PRICE;
    }

    @Override
    public int getMaxSpeed() {
        return 120;
    }

    @Override
    public String getFuelType() {
        return "Diesel";
    }
}
