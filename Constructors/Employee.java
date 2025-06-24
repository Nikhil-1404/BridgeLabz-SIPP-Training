// Superclass
class Employee {
    public int employeeID;         // public
    protected String department;   // protected
    private double salary;         // private

    // Constructor
    public Employee(int employeeID, String department, double salary) {
        this.employeeID = employeeID;
        this.department = department;
        this.salary = salary;
    }

    // Public method to modify salary
    public void setSalary(double newSalary) {
        if (newSalary > 0) {
            this.salary = newSalary;
        }
    }

    // Public method to get salary
    public double getSalary() {
        return this.salary;
    }
}

// Subclass
class Manager extends Employee {

    public Manager(int employeeID, String department, double salary) {
        super(employeeID, department, salary);
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeID);     // public access
        System.out.println("Department: " + department);      // protected access
        // Cannot access salary directly (private)
    }
}

// Main class to test
 class Main {
    public static void main(String[] args) {
        // Create Employee object
        Employee emp = new Employee(101, "HR", 50000);
        System.out.println("Employee Details:");
        System.out.println("Employee ID: " + emp.employeeID);
        System.out.println("Department: " + emp.department);
        System.out.println("Salary: $" + emp.getSalary());

        // Modify salary
        emp.setSalary(55000);
        System.out.println("Updated Salary: $" + emp.getSalary());

        // Create Manager object
        Manager mgr = new Manager(201, "Finance", 80000);
        System.out.println("\nManager Details:");
        mgr.displayInfo();
        System.out.println("Salary: $" + mgr.getSalary());
    }
}
