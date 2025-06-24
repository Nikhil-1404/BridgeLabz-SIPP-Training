public class LibraryBook {
    private String title;
    private String author;
    private double price;
    private boolean available;

    // Default constructor
    public LibraryBook() {
        title = "Unknown Title";
        author = "Unknown Author";
        price = 0.0;
        available = true; // by default, available
    }

    // Parameterized constructor
    public LibraryBook(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.available = true; // available by default
    }

    // Method to borrow the book
    public void borrowBook() {
        if (available) {
            available = false;
            System.out.println("You have successfully borrowed \"" + title + "\".");
        } else {
            System.out.println("\"" + title + "\" is currently not available.");
        }
    }

    // Method to display book details
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Available: " + available);
    }

    // Main method to test
    public static void main(String[] args) {
        LibraryBook book1 = new LibraryBook("The Alchemist", "Paulo Coelho", 9.99);
        book1.display();
        System.out.println();

        // Borrow the book
        book1.borrowBook();
        book1.borrowBook(); // Try borrowing again

        System.out.println();
        book1.display();
    }
}
