package Consultation_Logs;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Consultation {

    private Patient patient;
    private String diagnosis;
    private List<UsageLog> usageLogs = new ArrayList<>();
    private Date date = new Date();
    private boolean isCompleted = false;

    public Consultation(Patient patient) {
        this.patient = patient;
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

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public void addUsageLog(UsageLog log) {
        usageLogs.add(log);
    }
}