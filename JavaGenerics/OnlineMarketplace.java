import java.util.*;

// ---------- CATEGORY MARKERS ----------
interface Category {
    String getCategoryName();
}

class BookCategory implements Category {
    public String getCategoryName() {
        return "Books";
    }
}

class ClothingCategory implements Category {
    public String getCategoryName() {
        return "Clothing";
    }
}

class GadgetCategory implements Category {
    public String getCategoryName() {
        return "Gadgets";
    }
}

// ---------- PRODUCT CLASS ----------
class Product<T extends Category> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public T getCategory() {
        return category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void displayProduct() {
        System.out.println("Product: " + name +
                           " | Price: ₹" + price +
                           " | Category: " + category.getCategoryName());
    }
}

// ---------- GENERIC METHOD FOR DISCOUNT ----------
class DiscountUtility {
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double originalPrice = product.getPrice();
        double discount = originalPrice * (percentage / 100);
        product.setPrice(originalPrice - discount);
        System.out.println("Applied " + percentage + "% discount on " + product.getName() +
                           ". New Price: ₹" + product.getPrice());
    }
}


public class OnlineMarketplace {
    public static void main(String[] args) {
        // Creating products
        Product<BookCategory> book = new Product<>("Java Programming", 799.0, new BookCategory());
        Product<ClothingCategory> shirt = new Product<>("Formal Shirt", 1299.0, new ClothingCategory());
        Product<GadgetCategory> phone = new Product<>("Smartphone X", 14999.0, new GadgetCategory());

        // Catalog
        List<Product<? extends Category>> catalog = new ArrayList<>();
        catalog.add(book);
        catalog.add(shirt);
        catalog.add(phone);

        // Display catalog
        System.out.println("----- Product Catalog -----");
        for (Product<? extends Category> item : catalog) {
            item.displayProduct();
        }

        // Apply discounts
        System.out.println("\n----- Applying Discounts -----");
        DiscountUtility.applyDiscount(book, 10);    // 10% on books
        DiscountUtility.applyDiscount(shirt, 15);   // 15% on clothing
        DiscountUtility.applyDiscount(phone, 5);    // 5% on gadgets

        // Final display
        System.out.println("\n----- Updated Catalog -----");
        for (Product<? extends Category> item : catalog) {
            item.displayProduct();
        }
    }
}
