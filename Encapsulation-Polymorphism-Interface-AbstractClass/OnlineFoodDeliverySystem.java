// Interface Discountable
interface Discountable {
    void applyDiscount();
    String getDiscountDetails();
}

// Abstract class FoodItem
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Getters
    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    // Abstract method
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName + ", Price: " + price + ", Quantity: " + quantity);
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // no additional charges
    }

    @Override
    public void applyDiscount() {
        System.out.println("5% discount applied on Veg item.");
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount available.";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity() + 50; // Rs.50 additional charge
    }

    @Override
    public void applyDiscount() {
        System.out.println("10% discount applied on Non-Veg item.");
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount available.";
    }
}

// Main class
public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        FoodItem[] order = {
            new VegItem("Paneer Butter Masala", 250, 2),
            new NonVegItem("Chicken Biryani", 300, 1)
        };

        // Process order using polymorphism
        for (FoodItem item : order) {
            item.getItemDetails();
            System.out.println("Total Price: " + item.calculateTotalPrice());

            if (item instanceof Discountable) {
                ((Discountable) item).applyDiscount();
                System.out.println(((Discountable) item).getDiscountDetails());
            }
            System.out.println("------------------------------");
        }
    }
}
