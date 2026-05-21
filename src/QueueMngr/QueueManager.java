package QueueMngr;

import java.util.*;
import Consultation_Logs.*;

public class QueueManager {
    private Queue<QueueTicket> queue;

    public QueueManager() {
        queue = new LinkedList<>();
    }

    // --- ADDED THIS FOR GUI COMPATIBILITY ---
    // This allows the TableView in MainApp to access the queue data
    public List<QueueTicket> getQueue() {
        return new ArrayList<>(queue);
    }
    // ----------------------------------------

    public void addToQueue(QueueTicket ticket) {
        queue.add(ticket);
    }

    public Consultation getNextInQueueBySpeciality(String specialty, List<Consultation> consultationRecord) {
        for (QueueTicket ticket : queue) {
            if (ticket.doctorSpecialtyPreferred.equalsIgnoreCase(specialty)) {
                queue.remove(ticket);
                consultationRecord.add(ticket.consultation);
                return ticket.consultation;
            }
        }
        return null;
    }

    public void viewBySpecialty(String specialty) {
        for (QueueTicket ticket : queue) {
            if (ticket.doctorSpecialtyPreferred.equalsIgnoreCase(specialty)) {
                System.out.println("Ticket ID: " + ticket.ticketID + ", Preferred Specialty: " + ticket.doctorSpecialtyPreferred);
                ticket.consultation.displayConsultationDetails();
            }
        }
    }
}