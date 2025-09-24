import java.util.ArrayList;
import java.util.List;

class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void viewDoctors() {
        System.out.println("Patient: " + name);
    }
}

class Doctor {
    private String name;
    private List<Patient> patients = new ArrayList<>();

    public Doctor(String name) {
        this.name = name;
    }

    public void consult(Patient patient) {
        if (!patients.contains(patient)) {
            patients.add(patient);
        }
        System.out.println("Doctor " + name + " is consulting patient " + patient.getName());
    }

    public void displayPatients() {
        System.out.println("Doctor: " + name);
        for (Patient p : patients) {
            System.out.println("Patient: " + p.getName());
        }
    }
}

class Hospital {
    private String hospitalName;
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();

    public Hospital(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public void addDoctor(Doctor d) {
        doctors.add(d);
    }

    public void addPatient(Patient p) {
        patients.add(p);
    }

    public void displayHospital() {
        System.out.println("Hospital: " + hospitalName);
        for (Doctor d : doctors) {
            d.displayPatients();
            System.out.println();
        }
    }
}

public class Hospital_Doctors_and_Patients {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("City Hospital");

        Doctor doc1 = new Doctor("Dr. Smith");
        Doctor doc2 = new Doctor("Dr. Alice");

        Patient pat1 = new Patient("Lathika");
        Patient pat2 = new Patient("Lidiya");
        Patient pat3 = new Patient("Rohan");

        hospital.addDoctor(doc1);
        hospital.addDoctor(doc2);

        hospital.addPatient(pat1);
        hospital.addPatient(pat2);
        hospital.addPatient(pat3);

        doc1.consult(pat1);
        doc1.consult(pat2);

        doc2.consult(pat2);
        doc2.consult(pat3);

        hospital.displayHospital();
    }
}
