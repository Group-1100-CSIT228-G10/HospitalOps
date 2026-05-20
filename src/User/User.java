package User;

public class User {
    
    protected final String userID;
    private String password;
    protected final String firstName;
    protected final String lastName;
    protected final String middleName;
    protected final String gender;
    protected final String city;
    protected final String country;
    protected final String birthDate;
    protected final int age;

    public User(String userID, String password, String firstName, String lastName,
               String middleName, String gender, String city,
               String country, String birthDate, int age) { 
        this.userID     = userID;
        this.firstName  = firstName;
        this.lastName   = lastName;
        this.middleName = middleName;
        this.gender = gender;
        this.city = city;
        this.country = country;
        this.birthDate = birthDate;
        this.age = age;
        setPassword(password);
    }
    private void setPassword(String password) {
        // In a real application, you should hash the password before storing it
        this.password = password;
    }

    public boolean checkPassword(String password) {
        // In a real application, you would compare the hashed password
        return this.password.equals(password);
    }

    public String getPassword(String reason){
        if(reason.equals("admin")){
            return this.password;
        } else {
            return "Access Denied: Insufficient Permissions";
        }
    }

    public String getUserID() {
        return userID;
    }

    public String getFullName(){
        return getFirstName() + " " + getMiddleName() + " " + getLastName();
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
