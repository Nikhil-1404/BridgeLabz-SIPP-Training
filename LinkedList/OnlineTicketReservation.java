import java.util.Scanner;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    Ticket head = null;
    Ticket tail = null;

    // Add ticket at end
    void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            tail.next = head;
        } else {
            tail.next = newTicket;
            tail = newTicket;
            tail.next = head;
        }
        System.out.println("Ticket booked successfully for " + customerName);
    }

    // Remove ticket by Ticket ID
    void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head, prev = tail;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;
                if (current == head && current == tail) { // only node
                    head = tail = null;
                } else if (current == head) {
                    head = head.next;
                    tail.next = head;
                } else if (current == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = current.next;
                }
                System.out.println("Ticket with ID " + ticketId + " removed.");
                break;
            }
            prev = current;
            current = current.next;
        } while (current != head);

        if (!found) {
            System.out.println("Ticket ID not found.");
        }
    }

    // Display all tickets
    void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = head;
        System.out.println("Current Booked Tickets:");
        do {
            System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                               ", Movie: " + current.movieName + ", Seat: " + current.seatNumber +
                               ", Booking Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search ticket by Customer Name
    void searchByCustomerName(String name) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = head;
        boolean found = false;
        do {
            if (current.customerName.equalsIgnoreCase(name)) {
                System.out.println("Ticket ID: " + current.ticketId + ", Movie: " + current.movieName +
                                   ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No tickets found for customer " + name);
        }
    }

    // Search ticket by Movie Name
    void searchByMovieName(String movie) {
        if (head == null) {
            System.out.println("No tickets booked.");
            return;
        }
        Ticket current = head;
        boolean found = false;
        do {
            if (current.movieName.equalsIgnoreCase(movie)) {
                System.out.println("Ticket ID: " + current.ticketId + ", Customer: " + current.customerName +
                                   ", Seat: " + current.seatNumber + ", Booking Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);
        if (!found) {
            System.out.println("No tickets found for movie " + movie);
        }
    }

    // Calculate total number of booked tickets
    void totalTickets() {
        if (head == null) {
            System.out.println("Total booked tickets: 0");
            return;
        }
        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        System.out.println("Total booked tickets: " + count);
    }
}

public class OnlineTicketReservation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem trs = new TicketReservationSystem();
        int choice;

        do {
            System.out.println("\n*** Online Ticket Reservation System ***");
            System.out.println("1. Book New Ticket");
            System.out.println("2. Remove Ticket by ID");
            System.out.println("3. Display All Tickets");
            System.out.println("4. Search Ticket by Customer Name");
            System.out.println("5. Search Ticket by Movie Name");
            System.out.println("6. Total Booked Tickets");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String cname = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    String mname = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    String seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    String btime = sc.nextLine();
                    trs.addTicket(id, cname, mname, seat, btime);
                    break;
                case 2:
                    System.out.print("Enter Ticket ID to remove: ");
                    trs.removeTicket(sc.nextInt());
                    break;
                case 3:
                    trs.displayTickets();
                    break;
                case 4:
                    System.out.print("Enter Customer Name to search: ");
                    trs.searchByCustomerName(sc.nextLine());
                    break;
                case 5:
                    System.out.print("Enter Movie Name to search: ");
                    trs.searchByMovieName(sc.nextLine());
                    break;
                case 6:
                    trs.totalTickets();
                    break;
                case 7:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 7);

        sc.close();
    }
}
