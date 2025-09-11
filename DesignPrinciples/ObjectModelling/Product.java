import java.util.*;

// Product class
class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void displayProduct() {
        System.out.println("Product: " + name + ", Price: ₹" + price);
    }
}

// Order class (aggregates products)
class Order {
    private static int orderCounter = 1001;
    private int orderId;
    private Customer customer;
    private List<Product> products;

    public Order(Customer customer) {
        this.orderId = orderCounter++;
        this.customer = customer;
        this.products = new ArrayList<>();
    }

    // Add product to order
    public void addProduct(Product product) {
        products.add(product);
    }

    // Display order details
    public void displayOrder() {
        System.out.println("\nOrder ID: " + orderId + ", Customer: " + customer.getName());
        System.out.println("Products in this order:");
        for (Product p : products) {
            p.displayProduct();
        }
    }

    // Calculate total cost
    public double getTotal() {
        double total = 0;
        for (Product p : products) {
            total += p.getPrice();
        }
        return total;
    }
}

// Customer class
class Customer {
    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Place an order (communication)
    public Order placeOrder() {
        Order order = new Order(this);
        orders.add(order);
        System.out.println(name + " placed an order with ID: " + order.orderId);
        return order;
    }

    // Display all orders of this customer
    public void displayOrders() {
        System.out.println("\nOrders placed by " + name + ":");
        for (Order o : orders) {
            o.displayOrder();
            System.out.println("Total Cost: ₹" + o.getTotal());
        }
    }
}

// Main class to demonstrate e-commerce platform
 class Main {
    public static void main(String[] args) {
        // Create products
        Product p1 = new Product("Laptop", 50000);
        Product p2 = new Product("Mouse", 500);
        Product p3 = new Product("Keyboard", 1000);

        // Create customers
        Customer c1 = new Customer("Alice");
        Customer c2 = new Customer("Bob");

        // Customer 1 places an order
        Order o1 = c1.placeOrder();
        o1.addProduct(p1);
        o1.addProduct(p2);

        // Customer 2 places an order
        Order o2 = c2.placeOrder();
        o2.addProduct(p2);
        o2.addProduct(p3);

        // Customer 1 places another order
        Order o3 = c1.placeOrder();
        o3.addProduct(p3);

        // Display customer orders
        c1.displayOrders();
        c2.displayOrders();
    }
}
