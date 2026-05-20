package Consultation_Logs;

import java.util.*;

import Inventory.Item;

public class Consultation {

    private Patient patient;
    private String date;
    private List<String> symptoms;
    private UsageLog usageLog;
    private String diagnosis;
    public boolean isCompleted;

    public Consultation(Patient patient, String LogName, String date) {
        this.patient = patient;
        this.date = date;
        symptoms = new ArrayList<>();
        diagnosis = "";
        InitializeUsageLog(LogName);
        isCompleted = false;
    }

    public String getDate() {
        return date;
    }

    public List<String> getSymptoms(String reason) {
        if(reason.equals("admin")) {
            return symptoms;
        } else {
            System.out.println("Access Denied: Insufficient Permissions");
            return null;
        }
    }

    public UsageLog getUsageLog(String reason) {
        if(reason.equals("admin") || reason.equals("Need to review usage log")) {
            return usageLog;
        } else {
            System.out.println("Access Denied: Insufficient Permissions");
            return null;
        }
    }

    public String getDiagnosis(String reason) {
        if(reason.equals("admin")) {
            return diagnosis;
        } else {
            System.out.println("Access Denied: Insufficient Permissions");
            return null;
        }
    }

    public boolean isComplete(){
        return isCompleted;
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

    public void readSymptoms() {
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

    public void setDiagnosis(String diagnosis) {
        if(!isCompleted){
            this.diagnosis = diagnosis;
            isCompleted = true;
        } else {
            System.out.println("Cannot set diagnosis. Consultation is already completed.");
        }
    }

    public void displayConsultationDetails() {
        if(isCompleted){
            PatientDetails();
            readSymptoms();
            System.out.println("Diagnosis: " + diagnosis);
            if (usageLog != null) {
                usageLog.displayLog();
            }
        } else {
            System.out.println("Consultation is not completed yet. Please complete the consultation to view details."); 
        }
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