package org.javafullStack.Oops.Abstraction;

public class Car extends Vehicle{
    private int doors;
    private String transmission;
    private double milage;

    public Car(String brand, String model, int year, int doors, String transmission, double milage){
        super(brand, model, year);
        this.doors = doors;
        this.transmission = transmission;
        this.milage = milage;
    }


    @Override
    public void start() {
        System.out.println("🚗 " + getBrand() + " " + getModel()
                + " — engine ignited. 🔑");
        System.out.println("   Transmission: " + transmission);
    }

    @Override
    public void stop() {
        System.out.println("🚗 " + getBrand() + " " + getModel()
                + " — engine turned off. 🔴");
    }

    @Override
    public double calculateFuelCost(double distance) {
        double PERTROL_PRICE = 106.0;
        double literUsed = distance/milage;
        return literUsed * PERTROL_PRICE;
    }

    @Override
    public int getMaxSpeed() {
        return 180;
    }

    @Override
    public String getFuelType() {
        return "Petrol";
    }

    // Car - specific methods
    public void openBoot(){
        System.out.println("🚗 Boot opened on " + getModel());
    }
}
