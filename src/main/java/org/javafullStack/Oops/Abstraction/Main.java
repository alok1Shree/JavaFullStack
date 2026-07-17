package org.javafullStack.Oops.Abstraction;

public class Main {
    public static void main(String[] args) {
        System.out.println("╔═══════════════════════════════════════╗");
        System.out.println("║        VEHICLE MANAGEMENT SYSTEM      ║");
        System.out.println("╚═══════════════════════════════════════╝\n");

    // ── PROOF: Cannot instantiate abstract class ─────────
    // Vehicle v = new Vehicle(...);   ← COMPILE ERROR
    // "Vehicle is abstract; cannot be instantiated"
        System.out.println("✅ Vehicle (abstract) cannot be instantiated directly");

    // ── CREATE CONCRETE OBJECTS ──────────────────────────
    Car        car   = new Car("Toyota", "Camry", 2023, 4, "Automatic", 14.5);
    Truck      truck = new Truck("Tata", "Prima", 2022, 25.0, 6);
    ElectriCar ev   = new ElectriCar("Tesla", "Model 3", 2024, 75.0, 600);
    MotorCycle  bike = new MotorCycle("Royal Enfield", "Himalayan", 2023,
            "Off-Road", 30.0);

        System.out.println("\n==== STARTING ALL VEHICLES ====");
    // Abstract class reference — works for ALL concrete types
    Vehicle[] fleet = {car, truck, ev, bike};
        for (Vehicle v : fleet) {
        v.start();   // polymorphism — each calls its own start()
    }

        System.out.println("\n==== FUEL COST FOR 500 KM TRIP ====");
        for (Vehicle v : fleet) {
        double cost = v.calculateFuelCost(500);
        System.out.printf("%-25s | Fuel: %-10s | Cost: ₹%,.2f%n",
                v.getBrand() + " " + v.getModel(),
                v.getFuelType(),
                cost);
    }

        System.out.println("\n==== MAX SPEEDS ====");
        for (Vehicle v : fleet) {
        System.out.printf("%-25s | Max Speed: %3d km/h%n",
                v.getBrand() + " " + v.getModel(),
                v.getMaxSpeed());
    }

        System.out.println("\n==== BASIC INFO: Car & EV ====");
        car.displayBasicInfo();
        ev.displayBasicInfo();

        System.out.println("\n==== REFUELLING ====");
        car.refuel(30);    // concrete method from abstract class
        truck.refuel(50);

        System.out.println("\n==== EV CHARGING (EV-specific method) ====");
        ev.charge(2);      // ElectricCar-specific

        System.out.println("\n==== STOPPING ALL VEHICLES ====");
        for (Vehicle v : fleet) {
        v.stop();
    }
    }
}
