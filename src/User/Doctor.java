package User;

import java.util.*;
import Consultation_Logs.*;
import Inventory.*;

public class Doctor extends User {

    private String specialization;
    private List<Consultation> consultations = new ArrayList<>();
    private Consultation currentConsultation;

    public Doctor(String userID, String firstName, String lastName, String middleName,
              String gender, String city, String country,
              String birthDate, int age, String specialization) {

    super(userID, firstName, lastName, middleName, gender, city, country, birthDate, age);
    this.specialization = specialization;
    }

    public void startConsultation() {
        if(currentConsultation == null){
                currentConsultation = consultations.getFirst();
        }
        else if(consultations.isEmpty()){
            System.out.println("No consultations available.");
        }
        else{
            System.out.println("A consultation is already in progress. Please complete it before starting a new one.");
        }
    }

    public void consultationDetails() {
        if (currentConsultation != null) {
            System.out.println("Consultation Details:");
            System.out.println("Patient: " + currentConsultation.getPatient().getFullName());
            currentConsultation.getSymptoms();
            System.out.println("Diagnosis: " + currentConsultation.getDiagnosis());
        } else {
            System.out.println("No consultation in progress.");
        }
    }

    public void addItem(Item item) {
        if (currentConsultation != null) {
            if(currentConsultation.updateUsageLog(item)){
                System.out.println("Item " + item.name + " added to the consultation log.");
            } else {
                System.out.println("Failed to add item " + item.name + " to the consultation log.");
            }
        }
    }

    public void setDiagnosis(String diagnosis) {
        if (currentConsultation != null) {
            currentConsultation.setDiagnosis(diagnosis);
        }
    }

    public void completeConsultation() {
        if (currentConsultation != null) {
            currentConsultation.setCompleted(true);
            consultations.add(currentConsultation);
            currentConsultation = null;
        } else {
            System.out.println("No consultation in progress to complete.");
        }
    }

    // public String getSpecialization() {
    //     return specialization;
    // }

}