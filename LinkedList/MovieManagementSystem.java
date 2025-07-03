import java.util.Scanner;

class Movie {
    String title;
    String director;
    int year;
    double rating;
    Movie prev;
    Movie next;

    Movie(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

class MovieDoublyLinkedList {
    Movie head;
    Movie tail;

    // Add at beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add at end
    void addAtEnd(String title, String director, int year, double rating) {
        Movie newMovie = new Movie(title, director, year, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add at specific position (1-based index)
    void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position == 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }
        Movie newMovie = new Movie(title, director, year, rating);
        Movie current = head;
        for (int i = 1; current != null && i < position - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            System.out.println("Position out of bounds.");
        } else if (current.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newMovie.next = current.next;
            newMovie.prev = current;
            current.next.prev = newMovie;
            current.next = newMovie;
        }
    }

    // Remove by Movie Title
    void removeByTitle(String title) {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
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
                System.out.println("Movie deleted.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by Director
    void searchByDirector(String director) {
        boolean found = false;
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                System.out.println("Title: " + current.title + ", Year: " + current.year + ", Rating: " + current.rating);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found for this director.");
        }
    }

    // Search by Rating
    void searchByRating(double rating) {
        boolean found = false;
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year);
                found = true;
            }
            current = current.next;
        }
        if (!found) {
            System.out.println("No movies found with this rating.");
        }
    }

    // Display forward
    void displayForward() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }
        Movie current = head;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display reverse
    void displayReverse() {
        if (tail == null) {
            System.out.println("List is empty.");
            return;
        }
        Movie current = tail;
        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.year + ", Rating: " + current.rating);
            current = current.prev;
        }
    }

    // Update rating by Movie Title
    void updateRating(String title, double newRating) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                current.rating = newRating;
                System.out.println("Rating updated.");
                return;
            }
            current = current.next;
        }
        System.out.println("Movie not found.");
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieDoublyLinkedList list = new MovieDoublyLinkedList();
        int choice;

        do {
            System.out.println("\n*** Movie Management System ***");
            System.out.println("1. Add at Beginning");
            System.out.println("2. Add at End");
            System.out.println("3. Add at Specific Position");
            System.out.println("4. Remove by Movie Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Display All Movies Forward");
            System.out.println("8. Display All Movies Reverse");
            System.out.println("9. Update Rating by Movie Title");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    list.addAtBeginning(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble());
                    sc.nextLine();
                    break;
                case 2:
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    list.addAtEnd(sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble());
                    sc.nextLine();
                    break;
                case 3:
                    System.out.print("Enter Position: ");
                    int pos = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Title, Director, Year, Rating: ");
                    list.addAtPosition(pos, sc.nextLine(), sc.nextLine(), sc.nextInt(), sc.nextDouble());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.print("Enter Movie Title to remove: ");
                    list.removeByTitle(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter Director to search: ");
                    list.searchByDirector(sc.nextLine());
                    break;
                case 6:
                    System.out.print("Enter Rating to search: ");
                    list.searchByRating(sc.nextDouble());
                    sc.nextLine();
                    break;
                case 7:
                    list.displayForward();
                    break;
                case 8:
                    list.displayReverse();
                    break;
                case 9:
                    System.out.print("Enter Movie Title to update rating: ");
                    String title = sc.nextLine();
                    System.out.print("Enter new Rating: ");
                    double rating = sc.nextDouble();
                    sc.nextLine();
                    list.updateRating(title, rating);
                    break;
                case 10:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 10);

        sc.close();
    }
}
