package Consultation_Logs;

import java.util.*;

import Inventory.Item;

public class Consultation {

    private Patient patient;
    private ArrayList<String> symptoms;
    private String diagnosis;
    private Date date;
    private UsageLog usageLog;
    public boolean isCompleted;

    public Consultation(Patient patient, String LogName, Date date) {
        this.patient = patient;
        this.date = date;
        symptoms = new ArrayList<>();
        diagnosis = "";
        InitializeUsageLog(LogName);
        isCompleted = false;
    }

    public Patient getPatient() {
        return patient;
    }   

    public void PatientDetails() {
        System.out.println("Patient Details:");
        System.out.println("Name: " + patient.getFullName());
        System.out.println("Birth Date: " + patient.getBirthDate());
        System.out.println("Gender: " + patient.getGender());
        System.out.println("Address: " + patient.getAddress());   
        System.out.println("Consultation Date: " + date.toString() );
    }

    public void addSymptom(String symptom) {
        symptoms.add(symptom);
    }

    public void getSymptoms() {
        System.out.println("Symptoms for patient " + patient.getFullName() + ":");
        for (String symptom : symptoms) {
            System.out.println(symptom);
        }
    }

    public boolean updateUsageLog(Item item) {
        if (!isCompleted && usageLog != null) {
            usageLog.addItem(item);
            return true;
        } else {
            System.out.println("Cannot update usage log. Consultation is already completed.");
            return false;
        }
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public UsageLog getUsageLog() {
        return usageLog;
    }

    //private methods
    private void InitializeUsageLog(String logName) {
        if(usageLog == null){
            this.usageLog = new UsageLog(logName);
        }else{
            System.out.println("Usage log already initialized for this consultation.");
        }
    }
}