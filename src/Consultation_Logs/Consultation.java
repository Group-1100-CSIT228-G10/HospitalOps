package Consultation_Logs;

import java.util.List;
import java.util.ArrayList;

public class ConsultationRecord {

    private List<Consultation> consultations;

    public ConsultationRecord() {
        consultations = new ArrayList<>();
    }

    public void addConsultation(Consultation consultation) {
        consultations.add(consultation);
    }

    public List<Consultation> getAllConsultations() {
        return consultations;
    }

    public int getTotalConsultations() {
        return consultations.size();
    }
}