package Consultation_Logs;

public class Patient {

    private String firstName;
    private String middleName;
    private String lastName;
    private String gender;
    private String address;
    private String birthDate;

    public Patient() {}

    public Patient(String firstName, String middleName, String lastName,
                   String gender, String address, String birthDate) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.birthDate = birthDate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthDate() {
        return birthDate;
    }
    
    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }
}