package User;

public class User {

    private String userID;
    private String firstName;
    private String lastName;
    private String middleName;
    private String gender;
    private String city;
    private String country;
    private String birthDate;
    private int    age;

    public User() {}

    public User(String userID, String firstName, String lastName,
               String middleName, String gender, String city,
               String country, String birthDate, int age) { 
        this.userID     = userID;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.middleName = middleName;
        this.gender     = gender;
        this.city       = city;
        this.country    = country;
        this.birthDate  = birthDate;
        this.age        = age;
    }

    public String getUserID()     { return userID; }
    public String getFirstName()  { return firstName; }
    public String getLastName()   { return lastName; }
    public String getMiddleName() { return middleName; }
    public String getGender()     { return gender; }
    public String getCity()       { return city; }
    public String getCountry()    { return country; }
    public String getBirthDate()  { return birthDate; }
    public int    getAge()        { return age; }

    public void setUserID(String userID)         { this.userID     = userID; }
    public void setFirstName(String firstName)   { this.firstName  = firstName; }
    public void setLastName(String lastName)     { this.lastName   = lastName; }
    public void setMiddleName(String middleName) { this.middleName = middleName; }
    public void setGender(String gender)         { this.gender     = gender; }
    public void setCity(String city)             { this.city       = city; }
    public void setCountry(String country)       { this.country    = country; }
    public void setBirthDate(String birthDate)   { this.birthDate  = birthDate; }
    public void setAge(int age)                  { this.age        = age; }

}
