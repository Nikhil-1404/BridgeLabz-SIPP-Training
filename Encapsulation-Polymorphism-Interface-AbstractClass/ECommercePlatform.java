// Interface Taxable with methods to calculate tax
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract class Product with encapsulation
abstract class Product {
    private int productId;
    private String name;
    private double price;

    // Constructor
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();

    // Method to display product details
    public void displayDetails() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

// Electronics class implementing Taxable
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // 10% discount on electronics
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        // 18% GST on electronics
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() {
        return "18% GST applied on Electronics.";
    }
}

// Clothing class implementing Taxable
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // 20% discount on clothing
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        // 5% GST on clothing
        return getPrice() * 0.05;
    }

    @Override
    public String getTaxDetails() {
        return "5% GST applied on Clothing.";
    }
}

// Groceries class without tax (not implementing Taxable)
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        // 5% discount on groceries
        return getPrice() * 0.05;
    }
}

// Main class to test
public class ECommercePlatform {
    // Method to calculate and print final price using polymorphism
    public static void printFinalPrices(Product[] products) {
        for (Product p : products) {
            p.displayDetails();
            double discount = p.calculateDiscount();
            double tax = 0;
            String taxDetails = "No tax applicable.";

            if (p instanceof Taxable) {
                tax = ((Taxable) p).calculateTax();
                taxDetails = ((Taxable) p).getTaxDetails();
            }

            double finalPrice = p.getPrice() + tax - discount;

            System.out.println("Discount: " + discount);
            System.out.println("Tax: " + tax);
            System.out.println(taxDetails);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("------------------------------------");
        }
    }

    public static void main(String[] args) {
        // Creating products using polymorphism
        Product[] products = new Product[3];

        products[0] = new Electronics(201, "Laptop", 60000);
        products[1] = new Clothing(202, "T-Shirt", 800);
        products[2] = new Groceries(203, "Rice Bag", 1200);

        // Calculate and print final prices
        printFinalPrices(products);
    }
}
