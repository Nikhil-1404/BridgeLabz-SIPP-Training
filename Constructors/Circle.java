public class Circle {
    private double radius;

    // Default constructor
    public Circle() {
        this(1.0); // Calls the parameterized constructor with default value 1.0
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to display radius
    public void display() {
        System.out.println("Radius: " + radius);
    }

    // Main method to test it
    public static void main(String[] args) {
        Circle c1 = new Circle();         // Uses default constructor
        Circle c2 = new Circle(5.5);      // Uses parameterized constructor

        c1.display();
        c2.display();
    }
}
