package org.javafullStack.Oops.Abstraction;

public class MotorCycle extends Vehicle {

    private String bikeType;
    private double milage;

    public MotorCycle(String brand, String model, int year, String bikeType, double milage) {
        super(brand, model, year);
        this.bikeType = bikeType;
        this.milage = milage;
    }


    @Override
    public void start() {
        System.out.println("🏍️  " + getBrand() + " " + getModel()
                + " — " + bikeType + " bike started. VROOM!");
    }

    @Override
    public void stop() {
        System.out.println("🏍️  " + getBrand() + " " + getModel()
                + " — " + bikeType + " bike stopped.");

    }

    @Override
    public double calculateFuelCost(double distance) {
        double PETROL_PRICE = 106.0;
        return (distance * milage) * PETROL_PRICE;
    }

    @Override
    public int getMaxSpeed() {
        return 220;
    }

    @Override
    public String getFuelType() {
        return "Petrol";
    }
}
