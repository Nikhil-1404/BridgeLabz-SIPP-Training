// Superclass Book
class Book {
    String title;
    int publicationYear;

    // Constructor
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }

    // Method to display book information
    void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

// Subclass Author
class Author extends Book {
    String name;
    String bio;

    // Constructor
    Author(String title, int publicationYear, String name, String bio) {
        super(title, publicationYear);
        this.name = name;
        this.bio = bio;
    }

    // Overriding displayInfo() to include author details
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Bio: " + bio);
    }
}

// Main class to test the hierarchy
public class LibraryManagement {
    public static void main(String[] args) {
        // Creating an Author object with book details
        Author author = new Author(
            "Introduction to Java",
            2021,
            "James Gosling",
            "James Gosling is known as the father of Java programming language."
        );

        // Displaying book and author information
        System.out.println("=== Book and Author Details ===");
        author.displayInfo();
    }
}
