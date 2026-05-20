
import java.io.*;
import java.util.*;
import User.*;
import Inventory.*;
import Consultation_Logs.*;
import QueueMngr.*; 

public class HospitalOps {
    private static List<String> doctorSpecialties = List.of("General Practitioner", "Pediatrician", "Cardiologist", "Dermatologist", "Neurologist");
    private static List<User> users = new ArrayList<>();

    public static void EngineStart() {
        Scanner sc = new Scanner(System.in);    
        // Create some items
        System.out.println("Welcome to HospitalOps! A hospital management system designed to streamline operations and enhance patient care.");
        System.out.println("Are you a new user? (yes/no)");
        String newUser = sc.nextLine();

        User userInSession = null;
        if(newUser.equalsIgnoreCase("yes")) {
            System.out.println("What type of account would you like to create? (Doctor/Nurse/Admin)");
            String accountType = sc.nextLine();
            User newAccount;
            switch (accountType.toLowerCase()) {
                case "doctor":
                    newAccount = createDoctorAccount();
                    break;
                case "nurse":
                    newAccount = createNurseAccount();
                    break;
                case "admin":
                    newAccount = createAdminAccount();
                    break;
                default:
                    System.out.println("Invalid account type. Please try again.");
                    return;
            }
            users.add(newAccount);
            System.out.println("Account created successfully! You can now log in.");
        }else {
            userInSession = Login();
            if(userInSession == null) {
                return;
            }
        }

        private Inventory inventory = null;
        private QueueManager queueManager = null;
        private List<Consultation> consultationRecord = null;

        if(userInSession instanceof Doctor) {
            System.out.println("Welcome, Dr. " + userInSession.getFullName() + "! You can now access your dashboard.");
        } else if (userInSession instanceof Nurse) {
            System.out.println("Welcome, Nurse " + userInSession.getFullName() + "! You can now access your dashboard.");
        } else if (userInSession instanceof Admin) {
            System.out.println("Welcome, Admin " + userInSession.getFullName() + "! You can now access your dashboard.");
        }

    }







    private static User Login(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = sc.nextLine();
        System.out.print("Enter password: ");
        String password = sc.nextLine();

        for(User user : users) {
            if(user.getUserID().equals(username) && user.checkPassword(password)) {
                System.out.println("Login successful! Welcome, " + user.getFullName() + "!");
                return user;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
        return null;
    }

    private static Doctor createDoctorAccount() {
        Scanner sc = new Scanner(System.in);
        // Implementation for creating a doctor account
        System.out.print("Enter a username: ");
        String username = sc.nextLine();
        System.out.print("Enter a password: ");
        String password = sc.nextLine();
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter middle initial: ");
        String middleInitial = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter country: ");
        String country = sc.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        System.out.println("Select a specialty:");
        for (int i = 0; i < doctorSpecialties.size(); i++) {
            System.out.println((i + 1) + ". " + doctorSpecialties.get(i));
        }
        System.out.print("Enter your choice: ");
        int choice = sc.nextInt();
        sc.nextLine(); // Consume the newline character
        String specialty = doctorSpecialties.get(choice - 1);
        sc.nextLine(); // Consume the newline character

        return new Doctor(username, password, firstName, lastName, middleInitial, gender, address, country, dateOfBirth, age, specialty);
    }

    private static Nurse createNurseAccount() {
        Scanner sc = new Scanner(System.in);
        // Implementation for creating a nurse account
        System.out.print("Enter a username: ");
        String username = sc.nextLine();
        System.out.print("Enter a password: ");
        String password = sc.nextLine();
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter middle initial: ");
        String middleInitial = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter country: ");
        String country = sc.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        return new Nurse(username, password, firstName, lastName, middleInitial, gender, address, country, dateOfBirth, age);
    }

    private static Admin createAdminAccount() {
        Scanner sc = new Scanner(System.in);
        // Implementation for creating an admin account
        System.out.print("Enter a username: ");
        String username = sc.nextLine();
        System.out.print("Enter a password: ");
        String password = sc.nextLine();
        System.out.print("Enter first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter middle initial: ");
        String middleInitial = sc.nextLine();
        System.out.print("Enter gender: ");
        String gender = sc.nextLine();
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        System.out.print("Enter country: ");
        String country = sc.nextLine();
        System.out.print("Enter date of birth (YYYY-MM-DD): ");
        String dateOfBirth = sc.nextLine();
        System.out.print("Enter age: ");
        int age = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        return new Admin(username, password, firstName, lastName, middleInitial, gender, address, country, dateOfBirth, age);
    }

    private static void displayUserList() {
        System.out.println("Registered Users:");
        for(User user : users) {
            System.out.println("- " + user.getFullName() + " (" + user.getClass().getSimpleName() + ")");
        }
    }

    private void saveDatatoTextFile() {
        // Implementation for saving data to a text file
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter("hospital_data.txt"));
            for(User user : users) {
                writer.write(user.getUserID() + "," + user.getFullName() + "," + user.getClass().getSimpleName());
                writer.newLine();
            }
            System.out.println("Data saved to hospital_data.txt successfully!");
        } catch (IOException e) {
            System.out.println("An error occurred while saving data: " + e.getMessage());
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("An error occurred while closing the file: " + e.getMessage());
            }
        }
    }
}