package User;

public class User {

    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String city;
    private String country;
    private String birthDate;
    private int age;

    public User() {}

    public User(String firstName, String lastName, String middleName, String gender, String city, String country, String birthDate, int age) {
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

     public String getGender() {
    return gender;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public String getBirthDate() {
        return birthDate;
    }
    
    public int getAge() {
        return age;
    }
}