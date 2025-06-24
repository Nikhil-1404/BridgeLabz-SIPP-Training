public class Book {
    // Attributes
    String title;
    String author;
    double price;

    // Default constructor
    public Book() {
        title = "Unknown Title";
        author = "Unknown Author";
        price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
    }

    // Main method to test the class
    public static void main(String[] args) {
        // Using default constructor
        Book book1 = new Book();
        book1.displayDetails();

        System.out.println();

        // Using parameterized constructor
        Book book2 = new Book("Ramayan", "Kalidasa", 15.99);
        book2.displayDetails();
    }
}
