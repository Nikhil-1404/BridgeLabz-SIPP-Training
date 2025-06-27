import java.util.ArrayList;
import java.util.List;

// Book class (can exist independently)
class Book {
    private String title;
    private String author;

    // Constructor
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    // Display book details
    public void displayBook() {
        System.out.println("Book: " + title + " by " + author);
    }
}

// Library class aggregates Books
class Library {
    private String name;
    private List<Book> books; // Aggregation: Library has a list of Book objects

    // Constructor
    public Library(String name) {
        this.name = name;
        this.books = new ArrayList<>();
    }

    // Add book to library
    public void addBook(Book book) {
        books.add(book);
    }

    // Display library and its books
    public void displayLibrary() {
        System.out.println("\nLibrary: " + name);
        System.out.println("Books in this library:");
        for (Book book : books) {
            book.displayBook();
        }
    }
}

// Main class to demonstrate aggregation
 class Main {
    public static void main(String[] args) {
        // Create books (independent of any library)
        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Create libraries
        Library lib1 = new Library("Central Library");
        Library lib2 = new Library("Community Library");

        // Add books to libraries (aggregation)
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); // Shared book
        lib2.addBook(b3);

        // Display libraries and books
        lib1.displayLibrary();
        lib2.displayLibrary();
    }
}
