// Interface Department with required methods
interface Department {
    void assignDepartment(String deptName);
    String getDepartmentDetails();
}

// Abstract class Employee with encapsulation
abstract class Employee implements Department {
    private int employeeId;
    private String name;
    private double baseSalary;
    private String department;

    // Constructor
    public Employee(int employeeId, String name, double baseSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Getters and Setters
    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public String getDepartment() {
        return department;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    // Implementing Department interface methods
    @Override
    public void assignDepartment(String deptName) {
        this.department = deptName;
    }

    @Override
    public String getDepartmentDetails() {
        return "Department: " + department;
    }

    // Abstract method
    public abstract double calculateSalary();

    // Concrete method to display details
    public void displayDetails() {
        System.out.println("ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + baseSalary);
        System.out.println(getDepartmentDetails());
        System.out.println("Total Salary: " + calculateSalary());
        System.out.println("---------------------------------");
    }
}

// FullTimeEmployee class implementing calculateSalary()
class FullTimeEmployee extends Employee {
    private double fixedBonus;

    public FullTimeEmployee(int employeeId, String name, double baseSalary, double fixedBonus) {
        super(employeeId, name, baseSalary);
        this.fixedBonus = fixedBonus;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + fixedBonus;
    }
}

// PartTimeEmployee class implementing calculateSalary()
class PartTimeEmployee extends Employee {
    private int hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(int employeeId, String name, double baseSalary, int hoursWorked, double hourlyRate) {
        super(employeeId, name, baseSalary);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return getBaseSalary() + (hoursWorked * hourlyRate);
    }
}

// Main class to test
public class EmployeeManagementSystem {
    public static void main(String[] args) {
        // Polymorphism: using Employee reference
        Employee[] employees = new Employee[2];

        employees[0] = new FullTimeEmployee(101, "Alice", 30000, 5000);
        employees[0].assignDepartment("HR");

        employees[1] = new PartTimeEmployee(102, "Bob", 15000, 20, 500);
        employees[1].assignDepartment("Support");

        // Processing and displaying details
        for (Employee emp : employees) {
            emp.displayDetails();
        }
    }
}
