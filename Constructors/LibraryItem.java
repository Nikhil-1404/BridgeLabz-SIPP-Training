class LibraryItem {
    public String ISBN;           // public
    protected String title;       // protected
    private String author;        // private

    // Constructor
    public LibraryItem(String ISBN, String title) {
        this.ISBN = ISBN;
        this.title = title;
    }

    // Setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Getter for author
    public String getAuthor() {
        return this.author;
    }
}

// Subclass demonstrating access
class OnlineBook extends LibraryItem {

    public OnlineBook(String ISBN, String title) {
        super(ISBN, title);
    }

    public void displayDetails() {
        System.out.println("ISBN: " + ISBN);         // public access
        System.out.println("Title: " + title);       // protected access
        // Cannot access 'author' directly because it is private
    }
}

// Test class
 class Main {
    public static void main(String[] args) {
        // Create a LibraryItem object
        LibraryItem libItem = new LibraryItem("123-456-789", "Java Basics");
        libItem.setAuthor("Alice Johnson");

        System.out.println("Library Item Details:");
        System.out.println("ISBN: " + libItem.ISBN);
        System.out.println("Title: " + libItem.title);
        System.out.println("Author: " + libItem.getAuthor());

        // Create an OnlineBook object
        OnlineBook onlineBook = new OnlineBook("987-654-321", "Java Advanced");
        System.out.println("\nOnline Book Details:");
        onlineBook.displayDetails();
        // Set and get author using inherited methods
        onlineBook.setAuthor("Bob Smith");
        System.out.println("Author: " + onlineBook.getAuthor());
    }
}
