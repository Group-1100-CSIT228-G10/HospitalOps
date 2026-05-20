package User;

import java.util.*;
import Consultation_Logs.*;
import Inventory.*;

public class Doctor extends User {

    public String specialization;
    private Consultation currentConsultation;

    public Doctor(String userID, String password, String firstName, String lastName, String middleName,
              String gender, String city, String country,
              String birthDate, int age, String specialization) {

    super(userID, password, firstName, lastName, middleName, gender, city, country, birthDate, age);
    this.specialization = specialization;
    }

    public void startConsultation(Consultation consultation) {
        if(currentConsultation == null){
                currentConsultation = consultation;
        }
        else if(consultation == null){
            System.out.println("No consultations available.");
        }
        else if(currentConsultation.isCompleted){
            System.out.println("The current consultation is already completed.");
        }
        else{
            System.out.println("A consultation is already in progress. Please complete it before starting a new one.");
        }
    }

    public void viewPatientSymptoms() {
        if (currentConsultation != null) {
            currentConsultation.readSymptoms();
        } else {
            System.out.println("No consultation in progress.");
        }
    }

    public void addItem(String item, List<Item> availableItems) {
        if (currentConsultation != null) {
            for(Item i : availableItems) {
                if (i.name.equalsIgnoreCase(item)) {
                    if(currentConsultation.updateUsageLog(i)){
                        System.out.println("Item " + i.name + " added to the consultation log.");
                    } else {
                        System.out.println("Failed to add item " + i.name + " to the consultation log.");
                    }
                    return;
                }
            }
            System.out.println("Item not available.");
            return;
        }else{
            System.out.println("No consultation in progress.");
            return;
        }
    }

    public Consultation getCurrentConsultation(String reason) {
        if(reason.equalsIgnoreCase("Cannot diagnose") || reason.equalsIgnoreCase("Need to review symptoms") || reason.equalsIgnoreCase("Need to review usage log")) {
            if (currentConsultation != null) {
                return currentConsultation;
            } else {
                System.out.println("No consultation in progress.");
                return null;
            }
        } else {
            System.out.println("Invalid reason for accessing the consultation.");
            return null;
        }
    }

    public void setDiagnosis(String diagnosis, Queue<UsageLog> usageLogs) {
        if (currentConsultation != null) {
            currentConsultation.setDiagnosis(diagnosis);
            usageLogs.offer(currentConsultation.getUsageLog("Need to review usage log"));
            completeConsultation();
        }
    }

    public void completeConsultation() {
        if (currentConsultation != null) {
            currentConsultation.isCompleted = true;
            currentConsultation = null;
        } else {
            System.out.println("No consultation in progress to complete.");
        }
    }

    public void consultationSetToNull() {
        currentConsultation = null;
    }

    // public String getSpecialization() {
    //     return specialization;
    // }

}