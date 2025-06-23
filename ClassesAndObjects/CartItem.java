import java.util.ArrayList;

class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }
}

class ShoppingCart {
    ArrayList<CartItem> cartItems = new ArrayList<>();

    void addItem(String itemName, double price, int quantity) {
        cartItems.add(new CartItem(itemName, price, quantity));
        System.out.println(itemName + " added to the cart.");
    }

    void removeItem(String itemName) {
        boolean removed = false;
        for (int i = 0; i < cartItems.size(); i++) {
            if (cartItems.get(i).itemName.equals(itemName)) {
                cartItems.remove(i);
                System.out.println(itemName + " removed from the cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println(itemName + " not found in the cart.");
        }
    }

    void displayTotalCost() {
        double total = 0;
        for (CartItem item : cartItems) {
            total += item.price * item.quantity;
        }
        System.out.println("Total cost of items in cart: " + total);
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem("Laptop", 45000, 1);
        cart.addItem("Mouse", 500, 2);
        cart.displayTotalCost();
        cart.removeItem("Mouse");
        cart.displayTotalCost();
    }
}
