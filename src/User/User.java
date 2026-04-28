package User;

public class User {

    protected String firstName;
    protected String lastName;
    protected String middleName;
    protected String gender;
    protected String city;
    protected String country;
    protected String birthDate;
    protected int age;

    public User() {}

    public User(String firstName, String lastName, String middleName,
                String gender, String city, String country,
                String birthDate, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.city = city;
        this.country = country;
        this.birthDate = birthDate;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public int getAge() {
        return age;
    }
}