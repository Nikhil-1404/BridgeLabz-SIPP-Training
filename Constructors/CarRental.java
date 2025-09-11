public class CarRental {
    private String customerName;
    private String carModel;
    private int rentalDays;
    private double dailyRate;

    // Default constructor
    public CarRental() {
        customerName = "Unknown Customer";
        carModel = "Standard Car";
        rentalDays = 1;
        dailyRate = 50.0; // default daily rate
    }

    // Parameterized constructor
    public CarRental(String customerName, String carModel, int rentalDays, double dailyRate) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
        this.dailyRate = dailyRate;
    }

    // Calculate total cost
    public double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    // Display rental details
    public void display() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Daily Rate: $" + dailyRate);
        System.out.println("Total Cost: $" + calculateTotalCost());
    }

    // Test it
    public static void main(String[] args) {
        CarRental rental1 = new CarRental("Naman Yadav", "SUV", 5, 70.0);
        rental1.display();

        System.out.println();

        CarRental rental2 = new CarRental();
        rental2.display();
    }
}
