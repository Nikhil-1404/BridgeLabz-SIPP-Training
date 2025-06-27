import java.util.*;

// Patient class
class Patient {
    private String name;
    private List<Doctor> consultedDoctors;

    public Patient(String name) {
        this.name = name;
        this.consultedDoctors = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Add doctor to patient's consulted list
    public void addDoctor(Doctor doctor) {
        if (!consultedDoctors.contains(doctor)) {
            consultedDoctors.add(doctor);
        }
    }

    // Display doctors consulted by patient
    public void displayConsultedDoctors() {
        System.out.println("\nPatient " + name + " has consulted:");
        for (Doctor doc : consultedDoctors) {
            System.out.println("- Dr. " + doc.getName());
        }
    }
}

// Doctor class
class Doctor {
    private String name;
    private String specialization;
    private List<Patient> patients;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.patients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    // Consult a patient (communication method)
    public void consult(Patient patient) {
        System.out.println("Dr. " + name + " (" + specialization + ") is consulting patient " + patient.getName());
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        patient.addDoctor(this); // establish two-way association
    }

    // Display patients of this doctor
    public void displayPatients() {
        System.out.println("\nDr. " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println("- " + p.getName());
        }
    }
}

// Hospital class containing doctors and patients
class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    // Add doctor to hospital
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    // Add patient to hospital
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    // Display hospital details
    public void displayHospital() {
        System.out.println("\nHospital: " + name);
        System.out.println("Doctors:");
        for (Doctor d : doctors) {
            System.out.println("- Dr. " + d.getName() + " (" + d.specialization + ")");
        }
        System.out.println("Patients:");
        for (Patient p : patients) {
            System.out.println("- " + p.getName());
        }
    }
}

// Main class to demonstrate association and communication
 class Main {
    public static void main(String[] args) {
        // Create hospital
        Hospital apollo = new Hospital("Apollo Hospital");

        // Create doctors
        Doctor d1 = new Doctor("Smith", "Cardiology");
        Doctor d2 = new Doctor("Alice", "Neurology");

        // Create patients
        Patient p1 = new Patient("Bob");
        Patient p2 = new Patient("Charlie");

        // Add doctors and patients to hospital
        apollo.addDoctor(d1);
        apollo.addDoctor(d2);
        apollo.addPatient(p1);
        apollo.addPatient(p2);

        // Consultations (communication + association)
        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p1);

        // Display hospital details
        apollo.displayHospital();

        // Display doctor-patient relationships
        d1.displayPatients();
        d2.displayPatients();

        p1.displayConsultedDoctors();
        p2.displayConsultedDoctors();
    }
}
