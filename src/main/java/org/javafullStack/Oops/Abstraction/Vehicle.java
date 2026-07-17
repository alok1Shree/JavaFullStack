package org.javafullStack.Oops.Abstraction;

public abstract class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double fuelLevel;

    // Creating CONSTRUCTOR
    public Vehicle(String brand, String model, int year) {
        if(brand == null || brand.trim().isEmpty())
            throw new IllegalArgumentException("Brand cannot be null or empty");
        if(year<1886 || year>2025)
            throw new IllegalArgumentException("Year must be between 1886 and 2025");
        this.brand = brand.trim();
        this.model = model.trim();
        this.year = year;
        this.fuelLevel = 100.0; // Initialize fuel level to full
    }

    // Abstract methods
    abstract public void start();
    abstract public void stop();
    abstract public double calculateFuelCost(double distance);
    abstract public int getMaxSpeed();
    abstract public String getFuelType();

    // - GETTER/SETTER MEthods
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getFuelLevel() {
        return fuelLevel;
    }

    public void setFuelLevel(double fuelLevel) {
        this.fuelLevel = fuelLevel;
    }

    // CONCRETE METHODS
    public void refuel(double amount){
       if(amount <= 0){
           System.out.println("Refuel amount must be positive.");
           return;
       }
       fuelLevel = Math.min(100, fuelLevel+amount);
       System.out.printf("⛽ %s %s Refuelled. Level: %.1f%%%n ",brand, model, fuelLevel);
    }

    public void displayBasicInfo(){
        System.out.println("┌────────────────────────────────────┐");
        System.out.printf ("│  Brand     : %-21s│%n", brand);
        System.out.printf ("│  Model     : %-21s│%n", model);
        System.out.printf ("│  Year      : %-21d│%n", year);
        System.out.printf ("│  Fuel      : %-18.1f%%  │%n", fuelLevel);
        System.out.printf ("│  Type      : %-21s│%n",
                getClass().getSimpleName());
        System.out.println("└────────────────────────────────────┘");
    }
}
