class Employee {
    // 1. Static variable for company name
    static String companyName = "Tech Solutions Ltd.";
    static int totalEmployees = 0;

    // 3. Final variable for employee ID
    private final int id;
    private String name;
    private String designation;

    // 2. Constructor using 'this' keyword
    public Employee(int id, String name, String designation) {
        this.id = id;
        this.name = name;
        this.designation = designation;

        totalEmployees++;  // Increase employee count on each creation
    }

    // 1. Static method to display total number of employees
    public static void displayTotalEmployees() {
        System.out.println("Total Employees: " + totalEmployees);
    }

    // Method to display employee details
    public void displayDetails() {
        System.out.println("Company: " + companyName);
        System.out.println("Employee ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Designation: " + designation);
    }
}

 class Main {
    public static void main(String[] args) {
        // Creating Employee objects
        Employee emp1 = new Employee(101, "Ravi Kumar", "Software Engineer");
        Employee emp2 = new Employee(102, "Sneha Sharma", "Project Manager");

        // 4. instanceof check before displaying details
        if (emp1 instanceof Employee) {
            System.out.println("Employee 1 Details:");
            emp1.displayDetails();
        }

        if (emp2 instanceof Employee) {
            System.out.println("\nEmployee 2 Details:");
            emp2.displayDetails();
        }

        // Display total number of employees
        Employee.displayTotalEmployees();
    }
}
