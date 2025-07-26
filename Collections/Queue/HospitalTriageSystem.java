import java.util.*;

// Define the Patient class
class Patient {
    String name;
    int severity;

    public Patient(String name, int severity) {
        this.name = name;
        this.severity = severity;
    }

    @Override
    public String toString() {
        return name + " (Severity: " + severity + ")";
    }
}

public class HospitalTriageSystem {
    public static void main(String[] args) {
        // PriorityQueue with custom comparator: higher severity comes first
        PriorityQueue<Patient> triageQueue = new PriorityQueue<>(
            (p1, p2) -> Integer.compare(p2.severity, p1.severity)
        );

        // Add patients to the queue
        triageQueue.add(new Patient("John", 3));
        triageQueue.add(new Patient("Alice", 5));
        triageQueue.add(new Patient("Bob", 2));

        System.out.println("Patients will be treated in the following order:");
        while (!triageQueue.isEmpty()) {
            System.out.println(triageQueue.poll());
        }
    }
}
