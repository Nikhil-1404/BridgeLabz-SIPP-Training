class Vehicle {
    // 1. Static variable for common registration fee
    static double registrationFee = 5000.0;

    // 3. Final variable for unique registration number
    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    // 2. Constructor using 'this'
    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // 1. Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Owner Name: " + ownerName);
        System.out.println("Vehicle Type: " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
    }
}

 class VehicleMain {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MH12AB1234", "Anita Desai", "Car");
        Vehicle v2 = new Vehicle("MH14XY5678", "Ramesh Rao", "Bike");

        // 4. instanceof check before displaying details
        if (v1 instanceof Vehicle) {
            System.out.println("Vehicle 1 Details:");
            v1.displayDetails();
        }

        if (v2 instanceof Vehicle) {
            System.out.println("\nVehicle 2 Details:");
            v2.displayDetails();
        }

        // Update registration fee
        System.out.println("\nUpdating Registration Fee to ₹6000...\n");
        Vehicle.updateRegistrationFee(6000.0);

        // Show updated details
        if (v1 instanceof Vehicle) {
            System.out.println("Vehicle 1 Details After Fee Update:");
            v1.displayDetails();
        }
    }
}
