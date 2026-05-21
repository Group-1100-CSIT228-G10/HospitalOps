package QueueMngr;

import Consultation_Logs.*;

public class QueueTicket {
    public String ticketID;
    public String doctorSpecialtyPreferred;
    public Consultation consultation;

    public QueueTicket(String ticketID, String doctorSpecialtyPreferred, Consultation consultation) {
        this.ticketID = ticketID;
        this.doctorSpecialtyPreferred = doctorSpecialtyPreferred;
        this.consultation = consultation;
    }


    public String getTicketID() { return ticketID; }
    public String getSpecialty() { return doctorSpecialtyPreferred; }
}