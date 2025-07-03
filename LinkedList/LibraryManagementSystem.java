import java.util.Scanner;

class Book {
    String title;
    String author;
    String genre;
    int id;
    boolean available;
    Book prev;
    Book next;

    Book(String title, String author, String genre, int id, boolean available) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.id = id;
        this.available = available;
        this.prev = null;
        this.next = null;
    }
}

class LibraryDoublyLinkedList {
    Book head;
    Book tail;

    // Add at beginning
    void addAtBeginning(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
    }

    // Add at end
    void addAtEnd(String title, String author, String genre, int id, boolean available) {
        Book newBook = new Book(title, author, genre, id, available);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
    }

    // Add at specific position (1-based index)
    void addAtPosition(int position, String title, String author, String genre, int id, boolean available) {
        if (position == 1) {
            addAtBeginning(title, author, genre, id, available);
            return;
        }
        Book newBook = new Book(title, author, genre, id, available);
        Book current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
        } else if (current.next == null) {
            addAtEnd(title, author, genre, id, available);
        } else {
            newBook.next = current.next;
            newBook.prev = current;
            current.next.prev = newBook;
            current.next = newBook;
        }
    }

    // Remove by Book ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book current = head;
        while (current != null) {
            if (current.id == id) {
                if (current == head && current == tail) { // only node
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    head.prev = null;
                } else if (current == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                System.out.println("Book removed.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book ID not found.");
    }

    // Search by Book Title
    void searchByTitle(String title) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                System.out.println("ID: " + current.id + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + current.available);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found with this title.");
        }
    }

    // Search by Author
    void searchByAuthor(String author) {
        Book current = head;
        boolean found = false;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                System.out.println("Title: " + current.title + ", ID: " + current.id + ", Genre: " + current.genre + ", Available: " + current.available);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No books found for this author.");
        }
    }

    // Update Availability Status by Book ID
    void updateAvailability(int id, boolean newStatus) {
        Book current = head;
        while (current != null) {
            if (current.id == id) {
                current.available = newStatus;
                System.out.println("Availability status updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Book ID not found.");
    }

    // Display all books forward
    void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.id + ", Available: " + current.available);
            current = current.next;
        }
    }

    // Display all books reverse
    void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }
        Book current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", ID: " + current.id + ", Available: " + current.available);
            current = current.prev;
        }
    }

    // Count total number of books
    void countBooks() {
        int count = 0;
        Book current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        System.out.println("Total number of books: " + count);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LibraryDoublyLinkedList library = new LibraryDoublyLinkedList();
        int choice;

        do {
            System.out.println("\n*** Library Management System ***");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Specific Position");
            System.out.println("4. Remove by Book ID");
            System.out.println("5. Search by Book Title");
            System.out.println("6. Search by Author");
            System.out.println("7. Update Availability Status");
            System.out.println("8. Display All Books Forward");
            System.out.println("9. Display All Books Reverse");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Author, Genre, ID, Availability(true/false): ");
                    library.addAtBeginning(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("Enter Title, Author, Genre, ID, Availability(true/false): ");
                    library.addAtEnd(sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title, Author, Genre, ID, Availability(true/false): ");
                    library.addAtPosition(pos, sc.nextLine(), sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextBoolean());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.print("Enter Book ID to remove: ");
                    library.removeById(sc.nextInt());
                    sc.nextLine();
                    break;
                case 5:
                    System.out.print("Enter Book Title to search: ");
                    library.searchByTitle(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Enter Author to search: ");
                    library.searchByAuthor(sc.nextLine());
                    break;
                case 7:
                    System.out.print("Enter Book ID to update availability: ");
                    int id = sc.nextInt();
                    System.out.print("Enter new Availability(true/false): ");
                    boolean status = sc.nextBoolean();
                    library.updateAvailability(id, status);
                    sc.nextLine();
                    break;
                case 8:
                    library.displayForward();
                    break;
                case 9:
                    library.displayReverse();
                    break;
                case 10:
                    library.countBooks();
                    break;
                case 11:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 11);

        sc.close();
    }
}
