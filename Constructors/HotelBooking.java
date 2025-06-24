public class HotelBooking {
     String guestName;
     String roomType;
     int nights;

    // Default constructor
    public HotelBooking() {
        guestName = "Unknown Guest";
        roomType = "Standard";
        nights = 1;
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Display booking details
    public void display() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type: " + roomType);
        System.out.println("Nights: " + nights);
    }

    // Test it
    public static void main(String[] args) {
        HotelBooking booking1 = new HotelBooking("John ", "Deluxe", 3);
        HotelBooking booking2 = new HotelBooking(booking1);

        System.out.println("Original Booking:");
        booking1.display();

        System.out.println("\nCopied Booking:");
        booking2.display();
    }
}
