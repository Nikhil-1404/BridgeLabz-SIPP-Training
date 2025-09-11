class Book {
    // 1. Static variable shared by all Book objects
    static String libraryName = "City Central Library";

    // 3. Final variable for ISBN (unique identifier)
    private final String isbn;
    private String title;
    private String author;

    // Constructor using 'this' keyword
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;         // resolves ambiguity with constructor parameters
        this.title = title;
        this.author = author;
    }

    // 1. Static method to display the library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("ISBN: " + isbn);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

 class Main {
    public static void main(String[] args) {
        // Creating Book objects
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        Book book2 = new Book("978-0596009205", "Head First Java", "Kathy Sierra");

        // Display library name using static method
        Book.displayLibraryName();

        // 4. instanceof check before displaying details
        if (book1 instanceof Book) {
            System.out.println("\nBook 1 Details:");
            book1.displayDetails();
        }

        if (book2 instanceof Book) {
            System.out.println("\nBook 2 Details:");
            book2.displayDetails();
        }
    }
}
