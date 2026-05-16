package Consultation_Logs;

import java.util.*;

import Inventory.Item;

public class Consultation {

    private Patient patient;
    private ArrayList<String> symptoms;
    private String diagnosis;
    private Date date;
    private boolean isCompleted = false;
    private UsageLog usageLog;

    public Consultation(Patient patient) {
        this.patient = patient;
        symptoms = new ArrayList<>();
        diagnosis = "";
        date = new Date();
        usageLog = null;
    }

    public Patient getPatient() {
        if(patient == null){
            System.out.println("No patient assigned to this consultation.");
        }
        return patient;
    }

    public void addSymptom(String symptom) {
        symptoms.add(symptom);
    }

    public void getSymptoms() {
        System.out.println("Symptoms for patient " + patient.getFirstName() + " " + patient.getLastName() + ":");
        for (String symptom : symptoms) {
            System.out.println(symptom);
        }
    }


    public void InitializeUsageLog(String logName) {
        if(usageLog == null){
            this.usageLog = new UsageLog(logName);
        }else{
            System.out.println("Usage log already initialized for this consultation.");
        }
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

    public boolean isCompleted() {
        return isCompleted;
    }

    
    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    
    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }


}