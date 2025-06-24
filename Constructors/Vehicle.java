public class Vehicle {
    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Class variable (static) - shared by all vehicles
    private static double registrationFee = 100.0; // default fee

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: $" + registrationFee);
    }

    // Class method to update registration fee for all vehicles
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to: $" + registrationFee);
    }

    // Main method to test
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("John Doe", "Car");
        Vehicle v2 = new Vehicle("Alice Smith", "Motorcycle");

        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();

        System.out.println();

        // Update registration fee for all vehicles
        Vehicle.updateRegistrationFee(150.0);

        System.out.println();

        // Display again to confirm update
        v1.displayVehicleDetails();
        System.out.println();
        v2.displayVehicleDetails();
    }
}
