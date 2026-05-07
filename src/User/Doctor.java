package User;

import Consultation_Logs.*;
import java.util.ArrayList;
import java.util.List;

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

    public void startConsultation(Patient patient) {
        currentConsultation = new Consultation(patient);
    }

    public void addUsageLog(UsageLog log) {
        if (currentConsultation != null && !currentConsultation.isCompleted()) {
            currentConsultation.addUsageLog(log);
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
        }
    }

    public List<Consultation> getConsultations() {
        return consultations;
    }

    public Consultation getCurrentConsultation() {
        return currentConsultation;
    }

    public String getSpecialization() {
        return specialization;
    }
}