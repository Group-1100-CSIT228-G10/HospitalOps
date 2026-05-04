package User;

public class User {
    
    protected final String userID;
    protected final String firstName;
    protected final String lastName;
    protected final String middleName;
    protected final String gender;
    protected final String city;
    protected final String country;
    protected final String birthDate;
    protected final int age;


    public User(String userID, String firstName, String lastName, String middleName,
                String gender, String city, String country,
                String birthDate, int age) {
        
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.city = city;
        this.country = country;
        this.birthDate = birthDate;
        this.age = age;
    }


    // public String getFirstName() {
    //     return firstName;
    // }

    // public String getLastName() {
    //     return lastName;
    // }

    // public String getMiddleName() {
    //     return middleName;
    // }

    public String getFullName(){
        String prefix = ""; 
        if(gender.equalsIgnoreCase("Male")) prefix = "Mr.";
        else if(gender.equalsIgnoreCase("Female")) prefix = "Ms.";
        return prefix + firstName + " " + middleName + " " + lastName;
    }

    public int getAge() {
        return age;
    }
}
