// Interface MedicalRecord
interface MedicalRecord {
    void addRecord(String record);
    void viewRecords();
}

// Abstract class Patient
abstract class Patient implements MedicalRecord {
    private int patientId;
    private String name;
    private int age;
    private String diagnosis; // sensitive data

    // Constructor
    public Patient(int patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = "";
    }

    // Getters
    public int getPatientId() { return patientId; }
    public String getName() { return name; }
    public int getAge() { return age; }

    // Abstract method
    public abstract double calculateBill();

    // Concrete method
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId + ", Name: " + name + ", Age: " + age);
    }

    // Implement MedicalRecord
    @Override
    public void addRecord(String record) {
        diagnosis += record + "; ";
    }

    @Override
    public void viewRecords() {
        System.out.println("Medical Records: " + diagnosis);
    }
}

// InPatient class
class InPatient extends Patient {
    private int daysAdmitted;
    private double dailyRate;

    public InPatient(int patientId, String name, int age, int daysAdmitted, double dailyRate) {
        super(patientId, name, age);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
    }

    @Override
    public double calculateBill() {
        return daysAdmitted * dailyRate + 2000; // additional service charge
    }
}

// OutPatient class
class OutPatient extends Patient {
    private double consultationFee;

    public OutPatient(int patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    @Override
    public double calculateBill() {
        return consultationFee;
    }
}

// Main class
public class HospitalPatientManagement {
    public static void main(String[] args) {
        Patient[] patients = {
            new InPatient(301, "Alice", 30, 5, 1500),
            new OutPatient(302, "Bob", 45, 700)
        };

        // Process patients using polymorphism
        for (Patient p : patients) {
            p.getPatientDetails();
            p.addRecord("Initial checkup completed.");
            p.viewRecords();
            System.out.println("Total Bill: " + p.calculateBill());
            System.out.println("------------------------------");
        }
    }
}
