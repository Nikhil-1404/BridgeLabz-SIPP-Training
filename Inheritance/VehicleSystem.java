// Interface
interface Refuelable {
    void refuel();
}

// Superclass
class Vehicle {
    String model;
    int maxSpeed;

    Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    void displayDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Subclass 1: ElectricVehicle extends Vehicle
class ElectricVehicle extends Vehicle {
    int batteryCapacity; // in kWh

    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }

    void charge() {
        System.out.println(model + " is charging with " + batteryCapacity + " kWh battery capacity.");
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}

// Subclass 2: PetrolVehicle extends Vehicle and implements Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {
    int fuelCapacity; // in litres

    PetrolVehicle(String model, int maxSpeed, int fuelCapacity) {
        super(model, maxSpeed);
        this.fuelCapacity = fuelCapacity;
    }

    public void refuel() {
        System.out.println(model + " is refueling with " + fuelCapacity + " litres capacity.");
    }

    void displayDetails() {
        super.displayDetails();
        System.out.println("Fuel Capacity: " + fuelCapacity + " litres");
    }
}

// Main class to test hybrid inheritance
public class VehicleSystem {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 250, 75);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180, 40);

        System.out.println("=== Electric Vehicle Details ===");
        ev.displayDetails();
        ev.charge();
        System.out.println();

        System.out.println("=== Petrol Vehicle Details ===");
        pv.displayDetails();
        pv.refuel();
    }
}
