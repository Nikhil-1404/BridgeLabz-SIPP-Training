import java.util.*;

// Employee class (inner class within Department)
class Employee {
    private String name;
    private String designation;

    public Employee(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public void displayEmployee() {
        System.out.println("Employee: " + name + ", Designation: " + designation);
    }
}

// Department class (part of Company - composition)
class Department {
    private String name;
    private List<Employee> employees;

    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Add employee to department
    public void addEmployee(String empName, String designation) {
        Employee emp = new Employee(empName, designation);
        employees.add(emp);
    }

    // Display department details
    public void displayDepartment() {
        System.out.println("\nDepartment: " + name);
        for (Employee emp : employees) {
            emp.displayEmployee();
        }
    }

    // Clear all employees (for delete simulation)
    public void deleteDepartment() {
        employees.clear();
        System.out.println("Deleted all employees in " + name + " department.");
    }
}

// Company class (owns departments - composition)
class Company {
    private String name;
    private List<Department> departments;

    public Company(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
    }

    // Add a department to the company
    public Department addDepartment(String deptName) {
        Department dept = new Department(deptName);
        departments.add(dept);
        return dept;
    }

    // Display company details
    public void displayCompany() {
        System.out.println("Company: " + name);
        for (Department dept : departments) {
            dept.displayDepartment();
        }
    }

    // Delete company (removes all departments and employees)
    public void deleteCompany() {
        for (Department dept : departments) {
            dept.deleteDepartment(); // delete employees
        }
        departments.clear(); // delete departments
        System.out.println("All departments deleted. Company " + name + " deleted.");
    }
}

// Main class to demonstrate composition
 class Main {
    public static void main(String[] args) {
        // Create company
        Company tcs = new Company("TCS");

        // Add departments
        Department hr = tcs.addDepartment("HR");
        Department it = tcs.addDepartment("IT");

        // Add employees to departments
        hr.addEmployee("Alice", "HR Manager");
        hr.addEmployee("Bob", "HR Executive");

        it.addEmployee("Charlie", "Software Engineer");
        it.addEmployee("David", "Senior Developer");

        // Display company structure
        tcs.displayCompany();

        // Delete company (composition: deletes departments & employees)
        tcs.deleteCompany();
    }
}
