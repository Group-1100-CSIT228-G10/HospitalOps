package User;

public class Admin extends User{
    public Admin(String userID, String password, String firstName, String lastName,
                String middleName, String gender, String city, String country, 
                String birthDate, int age) {
        super(userID, password, firstName, lastName, middleName, gender, city, country, birthDate, age);
    }
    
}