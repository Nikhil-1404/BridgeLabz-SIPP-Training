// Interface Insurable with required methods
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract class Vehicle with encapsulation
abstract class Vehicle implements Insurable {
    private String vehicleNumber;
    private String type;
    private double rentalRate;
    private String insurancePolicyNumber;

    // Constructor
    public Vehicle(String vehicleNumber, String type, double rentalRate, String insurancePolicyNumber) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // No getter for insurancePolicyNumber to protect sensitive data

    // Setter for insurancePolicyNumber if update needed
    public void setInsurancePolicyNumber(String insurancePolicyNumber) {
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    // Display method
    public void displayDetails(int days) {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per day: " + rentalRate);
        System.out.println("Rental Cost for " + days + " days: " + calculateRentalCost(days));
        System.out.println("Insurance Cost: " + calculateInsurance());
        System.out.println(getInsuranceDetails());
        System.out.println("-------------------------------------");
    }
}

// Car class implementing calculateRentalCost and Insurable
class Car extends Vehicle {
    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // Rs.500 fixed service charge for car
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; // 15% of rental rate as insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Car insurance calculated at 15% of rental rate.";
    }
}

// Bike class implementing calculateRentalCost and Insurable
class Bike extends Vehicle {
    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; // 5% of rental rate as insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike insurance calculated at 5% of rental rate.";
    }
}

// Truck class implementing calculateRentalCost and Insurable
class Truck extends Vehicle {
    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate, insurancePolicyNumber);
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 2000; // Rs.2000 fixed service charge for truck
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.20; // 20% of rental rate as insurance
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck insurance calculated at 20% of rental rate.";
    }
}

// Main class to test
public class VehicleRentalSystem {
    public static void main(String[] args) {
        // Create vehicle array using polymorphism
        Vehicle[] vehicles = new Vehicle[3];

        vehicles[0] = new Car("CAR123", 1500, "CAR-POLICY-111");
        vehicles[1] = new Bike("BIKE456", 500, "BIKE-POLICY-222");
        vehicles[2] = new Truck("TRUCK789", 3000, "TRUCK-POLICY-333");

        int rentalDays = 5;

        // Process each vehicle
        for (Vehicle v : vehicles) {
            v.displayDetails(rentalDays);
        }
    }
}
