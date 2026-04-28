package Consultation_Logs;

import User.Doctor;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

public class Consultation {

    private Doctor doctor;
    private Patient patient;
    private String diagnosis;
    private List<UsageLog> usageLogs;
    private Date date;
    private boolean isCompleted;

    public Consultation(Doctor doctor, Patient patient, String diagnosis) {
        this.doctor = doctor;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.usageLogs = new ArrayList<>();
        this.date = new Date();
        this.isCompleted = false;
    }

    public void addUsageLog(UsageLog log) {
        if (isCompleted) {
            System.out.println("Cannot add usage log. Consultation is already completed.");
            return;
        }
        usageLogs.add(log);
    }

    public void completeConsultation() {
        this.isCompleted = true;
    }
    
    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public List<UsageLog> getUsageLogs() {
        return usageLogs;
    }
    
    public Date getDate() {
        return date;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public String getDoctorFullName() {
        return doctor.getFirstName() + " " + doctor.getMiddleName() + " " + doctor.getLastName();
    }

    public String getPatientFullName() {
        return patient.getFirstName() + " " + patient.getMiddleName() + " " + patient.getLastName();
    }
}