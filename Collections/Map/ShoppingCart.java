import java.util.*;

public class ShoppingCart {
    private HashMap<String, Double> productPriceMap = new HashMap<>();         // Stores product prices
    private LinkedHashMap<String, Integer> cart = new LinkedHashMap<>();       // Maintains insertion order

    // Add product with price to product list
    public void addProduct(String product, double price) {
        productPriceMap.put(product, price);
    }

    // Add item to cart
    public void addToCart(String product, int quantity) {
        if (!productPriceMap.containsKey(product)) {
            System.out.println("Product not found: " + product);
            return;
        }
        cart.put(product, cart.getOrDefault(product, 0) + quantity);
    }

    // Display cart in insertion order
    public void displayCartInOrder() {
        System.out.println("\nCart (Insertion Order):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String product = entry.getKey();
            int qty = entry.getValue();
            double price = productPriceMap.get(product);
            System.out.println(product + " × " + qty + " @ ₹" + price + " each");
        }
    }

    // Display cart sorted by product price
    public void displayCartSortedByPrice() {
        System.out.println("\nCart (Sorted by Price):");
        TreeMap<Double, List<String>> priceToProductMap = new TreeMap<>();

        for (String product : cart.keySet()) {
            double price = productPriceMap.get(product);
            priceToProductMap.putIfAbsent(price, new ArrayList<>());
            priceToProductMap.get(price).add(product);
        }

        for (Map.Entry<Double, List<String>> entry : priceToProductMap.entrySet()) {
            double price = entry.getKey();
            for (String product : entry.getValue()) {
                int qty = cart.get(product);
                System.out.println(product + " × " + qty + " @ ₹" + price);
            }
        }
    }

    // Display total bill
    public void displayTotal() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            total += productPriceMap.get(entry.getKey()) * entry.getValue();
        }
        System.out.println("\nTotal Amount: ₹" + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Adding products to system
        cart.addProduct("Milk", 50);
        cart.addProduct("Bread", 30);
        cart.addProduct("Eggs", 5);
        cart.addProduct("Butter", 80);

        // Adding items to cart
        cart.addToCart("Milk", 2);
        cart.addToCart("Eggs", 12);
        cart.addToCart("Bread", 1);
        cart.addToCart("Butter", 1);

        // Display
        cart.displayCartInOrder();
        cart.displayCartSortedByPrice();
        cart.displayTotal();
    }
}
