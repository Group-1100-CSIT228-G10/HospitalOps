package User;

public class Nurse extends User{
    public int NurseId;
    public boolean isAvailable;

    public Nurse(String userID, String firstName, String lastName, String middleName,
                String gender, String city, String country,
                String birthDate, int age, int NurseId, boolean isAvailable){
        super(userID, firstName, lastName, middleName, gender, city, country, birthDate, age);
        
        this.NurseId = NurseId;
        this.isAvailable = isAvailable;
    }
}