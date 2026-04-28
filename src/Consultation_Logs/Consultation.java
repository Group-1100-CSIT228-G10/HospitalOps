package Consultation_Logs;

import User.Doctor;
import java.util.List;
import java.util.ArrayList;

public class Consultation {

    private Doctor doctor;
    private Patient patient;
    private String diagnosis;
    private List<UsageLog> usageLogs;

    public Consultation(Doctor doctor, Patient patient, String diagnosis) {
        this.doctor = doctor;
        this.patient = patient;
        this.diagnosis = diagnosis;
        this.usageLogs = new ArrayList<>();
    }

    public void addUsageLog(UsageLog log) {
        usageLogs.add(log);
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
}