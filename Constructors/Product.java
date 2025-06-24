public class Product {
    // Instance variables
    private String productName;
    private double price;

    // Class variable (static)
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++; // Increment when a product is created
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: $" + price);
    }

    // Class method to display total products
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    // Main method to test
    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 750.00);
        Product p2 = new Product("Phone", 400.00);
        Product p3 = new Product("Headphones", 50.00);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();
        System.out.println();
        p3.displayProductDetails();
        System.out.println();

        // Call the class method to show total products
        Product.displayTotalProducts();
    }
}
