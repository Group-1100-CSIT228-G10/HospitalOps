package User;

public class Admin extends User {

    private String role;

    public Admin(String userID, String firstName, String lastName,
                String middleName, String gender, String city, String country, 
                String birthDate, int age, String role) {
        super(userID, firstName, lastName, middleName, gender, city, country, birthDate, age);
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}