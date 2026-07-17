package org.javafullStack.Oops.Abstraction;

public class ElectriCar extends Vehicle{

    private double batteryCapacity;
    private double chargeLevel;
    private int range;

    public ElectriCar(String brand, String model, int year, double batteryCapacity, int range) {
        super(brand, model, year);
        this.batteryCapacity = batteryCapacity;
        this.chargeLevel = 100.0;
        this.range = range;
    }

    @Override
    public void start() {
        System.out.println("⚡ " + getBrand() + " EV — silently powered on. 🔋");
        System.out.printf ("   Battery: %.1f%% | Range: %d km%n",
                chargeLevel, range);
    }

    @Override
    public void stop() {
        System.out.println("⚡ " + getBrand() + " EV — powered down. 🔴");
    }

    @Override
    public double calculateFuelCost(double distance) {
        double ELECTRICITY_RATE = 8.0;
        double kwhUsed = (distance/range)*batteryCapacity;
    return kwhUsed * ELECTRICITY_RATE;
    }

    @Override
    public int getMaxSpeed() {
        return 250;
    }

    @Override
    public String getFuelType() {
        return "Electric";
    }

    public void charge(double hours){
        double chargeGained = hours * 20;
        chargeLevel = Math.min(100, chargeLevel+chargeGained);
        System.out.printf("⚡ Charging for %.1f hours. Charge level: %.1f%%%n", hours, chargeLevel);
    }
}
