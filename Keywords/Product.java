class Product {
    // 1. Static variable shared by all products
    static double discount = 10.0; // in percent

    // 3. Final variable for unique product ID
    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    // 2. Constructor using 'this' keyword
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // 1. Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    // Method to calculate total price after discount
    public double getTotalPrice() {
        double total = price * quantity;
        double discountAmount = total * (discount / 100);
        return total - discountAmount;
    }

    // Method to display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productID);
        System.out.println("Name: " + productName);
        System.out.println("Price: ₹" + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Discount: " + discount + "%");
        System.out.println("Total Price After Discount: ₹" + getTotalPrice());
    }
}

 class Main {
    public static void main(String[] args) {
        // Creating product objects
        Product p1 = new Product(1, "Laptop", 50000.0, 1);
        Product p2 = new Product(2, "Headphones", 1500.0, 2);

        // 4. instanceof check before displaying product details
        if (p1 instanceof Product) {
            System.out.println("Product 1 Details:");
            p1.displayDetails();
        }

        if (p2 instanceof Product) {
            System.out.println("\nProduct 2 Details:");
            p2.displayDetails();
        }

        // Update discount using static method
        System.out.println("\nUpdating Discount to 15%...\n");
        Product.updateDiscount(15.0);

        // Display updated prices
        if (p1 instanceof Product) {
            System.out.println("Product 1 Details After Discount Update:");
            p1.displayDetails();
        }

        if (p2 instanceof Product) {
            System.out.println("\nProduct 2 Details After Discount Update:");
            p2.displayDetails();
        }
    }
}
