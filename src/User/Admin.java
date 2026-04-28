package User;

public class Admin extends User {

    private String role;

    public Admin(String firstName, String lastName, String middleName, String gender, String city, String country, String birthDate, int age, String role) {
        super(firstName, lastName, middleName, gender, city, country, birthDate, age);
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}