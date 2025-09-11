// Interface GPS
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class Vehicle
abstract class Vehicle implements GPS {
    private int vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    // Constructor
    public Vehicle(int vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    // Getters
    public int getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    // Abstract method
    public abstract double calculateFare(double distance);

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId + ", Driver: " + driverName + ", Rate/Km: " + ratePerKm);
    }

    // Implement GPS
    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        this.currentLocation = newLocation;
        System.out.println("Location updated to " + newLocation);
    }
}

// Car class
class Car extends Vehicle {
    public Car(int vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 50; // Rs.50 base charge
    }
}

// Bike class
class Bike extends Vehicle {
    public Bike(int vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance; // no base charge
    }
}

// Auto class
class Auto extends Vehicle {
    public Auto(int vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return getRatePerKm() * distance + 20; // Rs.20 base charge
    }
}

// Main class
public class RideHailingApplication {
    public static void main(String[] args) {
        Vehicle[] rides = {
            new Car(401, "Driver A", 15, "Station"),
            new Bike(402, "Driver B", 10, "Market"),
            new Auto(403, "Driver C", 12, "Mall")
        };

        double distance = 10; // example

        // Calculate fare using polymorphism
        for (Vehicle v : rides) {
            v.getVehicleDetails();
            System.out.println("Fare for " + distance + " km: " + v.calculateFare(distance));
            System.out.println("Current Location: " + v.getCurrentLocation());
            v.updateLocation("Destination");
            System.out.println("------------------------------");
        }
    }
}
