class Patient {
    // 1. Static variable for hospital name
    static String hospitalName = "City Care Hospital";
    static int totalPatients = 0;

    // 3. Final variable for patient ID
    private final int patientID;
    private String name;
    private int age;
    private String ailment;

    // 2. Constructor using 'this'
    public Patient(int patientID, String name, int age, String ailment) {
        this.patientID = patientID;
        this.name = name;
        this.age = age;
        this.ailment = ailment;
        totalPatients++;
    }

    // 1. Static method to get total patients
    public static void getTotalPatients() {
        System.out.println("Total Patients Admitted: " + totalPatients);
    }

    // Method to display patient details
    public void displayDetails() {
        System.out.println("Hospital: " + hospitalName);
        System.out.println("Patient ID: " + patientID);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Ailment: " + ailment);
    }
}

 class HospitalMain {
    public static void main(String[] args) {
        Patient p1 = new Patient(201, "Meena Joshi", 45, "Diabetes");
        Patient p2 = new Patient(202, "Rajeev Sharma", 60, "Heart Disease");

        // 4. instanceof check before displaying details
        if (p1 instanceof Patient) {
            System.out.println("Patient 1 Details:");
            p1.displayDetails();
        }

        if (p2 instanceof Patient) {
            System.out.println("\nPatient 2 Details:");
            p2.displayDetails();
        }

        // Display total patients
        System.out.println();
        Patient.getTotalPatients();
    }
}
