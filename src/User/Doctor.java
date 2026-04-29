package User;

public class Doctor extends User {

    private String specialization;

    public Doctor() {}

    public Doctor(String firstName, String lastName, String middleName, String gender, String city, String country, String birthDate, int age, String specialization) {
        super(firstName, lastName, middleName, gender, city, country, birthDate, age);
        this.specialization = specialization;
    }

    public String getSpecialization() {
    return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

}