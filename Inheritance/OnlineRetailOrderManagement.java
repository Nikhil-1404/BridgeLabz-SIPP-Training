// Base class Order
class Order {
    String orderId;
    String orderDate;

    // Constructor
    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    // Method to get order status
    String getOrderStatus() {
        return "Order Placed";
    }

    // Display method
    void displayInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}

// Subclass ShippedOrder
class ShippedOrder extends Order {
    String trackingNumber;

    // Constructor
    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    String getOrderStatus() {
        return "Order Shipped, Tracking Number: " + trackingNumber;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}

// Subclass DeliveredOrder extending ShippedOrder
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;

    // Constructor
    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    String getOrderStatus() {
        return "Order Delivered on " + deliveryDate;
    }

    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}

// Main class to test the multilevel hierarchy
public class OnlineRetailOrderManagement {
    public static void main(String[] args) {
        // Creating an Order object
        Order order = new Order("ORD001", "2025-07-01");
        System.out.println("=== Order Details ===");
        order.displayInfo();

        System.out.println();

        // Creating a ShippedOrder object
        ShippedOrder shippedOrder = new ShippedOrder("ORD002", "2025-07-01", "TRK123456");
        System.out.println("=== Shipped Order Details ===");
        shippedOrder.displayInfo();

        System.out.println();

        // Creating a DeliveredOrder object
        DeliveredOrder deliveredOrder = new DeliveredOrder("ORD003", "2025-06-28", "TRK789012", "2025-07-01");
        System.out.println("=== Delivered Order Details ===");
        deliveredOrder.displayInfo();
    }
}
