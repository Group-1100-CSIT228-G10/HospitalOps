package Consultation_Logs;

import java.util.*;

import Inventory.Item;

public class Consultation {

    private Patient patient;
    private String diagnosis;
    private Date date = new Date();
    private boolean isCompleted = false;
    private UsageLog usageLog;

    public Consultation(Patient patient) {
        this.patient = patient;
        diagnosis = "";
        usageLog = null;
    }

    public Patient getPatient() {
        return patient;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public boolean updateUsageLog(Item item) {
        if (!isCompleted) {
            usageLog.addItem(item);
            return true;
        } else {
            System.out.println("Cannot update usage log. Consultation is already completed.");
            return false;
        }

    }

    public void InitializeUsageLog(String logName) {
        if(usageLog == null){
            this.usageLog = new UsageLog(logName);
        }else{
            System.out.println("Usage log already initialized for this consultation.");
        }
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

}