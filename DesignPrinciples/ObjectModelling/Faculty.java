import java.util.*;

// Faculty class (aggregation - can exist independently)
class Faculty {
    private String name;
    private String designation;

    public Faculty(String name, String designation) {
        this.name = name;
        this.designation = designation;
    }

    public void displayFaculty() {
        System.out.println("Faculty: " + name + ", Designation: " + designation);
    }
}

// Department class (composition - exists only within University)
class Department {
    private String deptName;

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public void displayDepartment() {
        System.out.println("Department: " + deptName);
    }
}

// University class (composition with Department, aggregation with Faculty)
class University {
    private String name;
    private List<Department> departments;
    private List<Faculty> faculties;

    public University(String name) {
        this.name = name;
        this.departments = new ArrayList<>();
        this.faculties = new ArrayList<>();
    }

    // Add department (composition)
    public void addDepartment(String deptName) {
        Department dept = new Department(deptName);
        departments.add(dept);
    }

    // Add faculty (aggregation)
    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    // Display university details
    public void displayUniversity() {
        System.out.println("\nUniversity: " + name);
        System.out.println("Departments:");
        for (Department dept : departments) {
            dept.displayDepartment();
        }
        System.out.println("Faculties:");
        for (Faculty fac : faculties) {
            fac.displayFaculty();
        }
    }

    // Delete university (deletes departments only)
    public void deleteUniversity() {
        departments.clear();
        System.out.println("\nUniversity " + name + " deleted along with all its departments.");
    }
}

// Main class to demonstrate composition and aggregation
 class Main {
    public static void main(String[] args) {
        // Create faculties (independent objects)
        Faculty f1 = new Faculty("Dr. Smith", "Professor");
        Faculty f2 = new Faculty("Dr. John", "Associate Professor");

        // Create university
        University iit = new University("IIT Delhi");

        // Add departments (composition)
        iit.addDepartment("Computer Science");
        iit.addDepartment("Mechanical Engineering");

        // Add faculty (aggregation)
        iit.addFaculty(f1);
        iit.addFaculty(f2);

        // Display university structure
        iit.displayUniversity();

        // Delete university (deletes departments)
        iit.deleteUniversity();

        // Faculties still exist (aggregation)
        System.out.println("\nFaculties still exist independently:");
        f1.displayFaculty();
        f2.displayFaculty();
    }
}
