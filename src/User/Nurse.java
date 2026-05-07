package User;

public class Nurse extends User {

    private String department;

    public Nurse(String userID, String firstName, String lastName, 
                String middleName, String gender, String city, 
                String country, String birthDate, int age, String department) { 
        super(userID, firstName, lastName, middleName, gender, city, country, birthDate, age);
        this.department = department;
    }

    public String getDepartment() {
        return department;
    }
}

