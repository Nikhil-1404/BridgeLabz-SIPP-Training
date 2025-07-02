// Interface Reservable
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class LibraryItem
abstract class LibraryItem implements Reservable {
    private int itemId;
    private String title;
    private String author;
    private String borrower; // sensitive data

    // Constructor
    public LibraryItem(int itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrower = null;
    }

    // Getters
    public int getItemId() { return itemId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    // Abstract method
    public abstract int getLoanDuration();

    // Concrete method
    public void getItemDetails() {
        System.out.println("ID: " + itemId + ", Title: " + title + ", Author: " + author);
    }

    // Implement Reservable
    @Override
    public void reserveItem(String borrowerName) {
        if (borrower == null) {
            borrower = borrowerName;
            System.out.println(title + " reserved by " + borrowerName);
        } else {
            System.out.println(title + " is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return borrower == null;
    }
}

// Book class
class Book extends LibraryItem {
    public Book(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days for books
    }
}

// Magazine class
class Magazine extends LibraryItem {
    public Magazine(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days for magazines
    }
}

// DVD class
class DVD extends LibraryItem {
    public DVD(int itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3; // 3 days for DVDs
    }
}

// Main class
public class LibraryManagementSystem {
    public static void main(String[] args) {
        LibraryItem[] items = {
            new Book(101, "Java Basics", "Author A"),
            new Magazine(102, "Tech Today", "Editor B"),
            new DVD(103, "Interstellar", "Director C")
        };

        // Polymorphic processing
        for (LibraryItem item : items) {
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");
            item.reserveItem("Student1");
            System.out.println("Available: " + item.checkAvailability());
            System.out.println("------------------------------");
        }
    }
}
