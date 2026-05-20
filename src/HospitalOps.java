
import java.io.*;
import java.util.*;
import User.*;
import Inventory.*;
import Consultation_Logs.*;
import QueueMngr.*; 
import Manager.*;

public class HospitalOps {
    private static Scanner sc = new Scanner(System.in);
    private static List<String> doctorSpecialties = List.of("General Practitioner", "Pediatrician", "Cardiologist", "Dermatologist", "Neurologist");
    private static List<User> users = new ArrayList<>();
    private static Queue<UsageLog> usageLogs = new LinkedList<>();
    private static List<Consultation> consultationRecord = new ArrayList<>();
    private static QueueManager queueManager = new QueueManager();
    private static Inventory inventory;

    public static void EngineStart() {
        // Create some items
        System.out.println("Welcome to HospitalOps! A hospital management system designed to streamline operations and enhance patient care.");
        System.out.print("Are you a new user? (yes/no): ");
        String newUser = sc.nextLine();

        User userInSession = null;
        if(newUser.equalsIgnoreCase("yes")) {
            System.out.println("What type of account would you like to create? (Doctor or Nurse)");
            String accountType = sc.nextLine();
            User newAccount;
            switch (accountType.toLowerCase()) {
                case "doctor":
                    newAccount = createDoctorAccount();
                    break;
                case "nurse":
                    newAccount = createNurseAccount();
                    break;
                default:
                    System.out.println("Invalid account type. Please try again.");
                    return;
            }
            users.add(newAccount);
            System.out.println("Account created successfully! You can now log in.");
        }
        
        while(userInSession == null) {
            System.out.print("Enter username: ");
            String username = sc.nextLine();
            System.out.print("Enter password: ");
            String password = sc.nextLine();
            if(username.equalsIgnoreCase("exit") || password.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the system. Goodbye!");
                return;
            }
            userInSession = Login(username, password);
        }

        inventory = initializeInventory();

        if(userInSession instanceof Doctor) {
            System.out.println("Welcome, Dr. " + userInSession.getFullName() + "! You can now access your dashboard.");
            DoctorDashboard((Doctor) userInSession, queueManager, consultationRecord, inventory, usageLogs);
        } else if (userInSession instanceof Nurse) {
            System.out.println("Welcome, Nurse " + userInSession.getFullName() + "! You can now access your dashboard.");
        }else {
            System.out.println("Unknown user type. Access denied.");
            return;
        }

    }







    private static User Login(String username, String password) {
        for(User user : users) {
            if(user.getUserID().equals(username) && user.checkPassword(password)) {
                System.out.println("Login successful! Welcome, " + user.getFullName() + "!");
                return user;
            }
        }
        System.out.println("Invalid username or password. Please try again.");
        return null;
    }

    

    public static void DoctorDashboard(Doctor doctor, QueueManager queueManager, List<Consultation> consultationRecord, Inventory inventory, Queue<UsageLog> usageLogs) {
        int option;
        do {
            System.out.println("Doctor Dashboard for Dr. " + doctor.getFullName());
            System.out.println("What would you like to do?");
            System.out.println("1. View Queue of Consultations");
            System.out.println("2. Start a Consultation");
            System.out.println("0. Exit Dashboard");
            System.out.print("Option: ");
            option = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    queueManager.viewBySpecialty(doctor.specialization);
                    break;
                case 2:
                    doctor.startConsultation(queueManager.getNextInQueueBySpeciality(doctor.specialization, consultationRecord));
                    doctor.viewPatientSymptoms();
                    while(true) {
                        System.out.println("Would you like to use an item? (yes/no)");
                        String addItem = sc.nextLine();
                        if(addItem.equalsIgnoreCase("yes")) {
                            System.out.println("Enter the name of the item to add:");
                            String itemName = sc.nextLine();
                            doctor.addItem(itemName, inventory.getAvailableItems("admin"));
                        } else {
                            System.out.println();
                            break;
                        }
                    }
                    System.out.println("Would you like to set a diagnosis? (yes/no)");
                    String setDiagnosis = sc.nextLine();
                        if(setDiagnosis.equalsIgnoreCase("yes")) {
                            System.out.println("Enter the diagnosis:");
                            String diagnosis = sc.nextLine();
                            doctor.setDiagnosis(diagnosis, usageLogs);
                            System.out.println("Consultation completed and recorded.");
                        }else{
                            queueManager.addToQueue(new QueueTicket(Integer.toString(new Random().nextInt(1000)), doctor.specialization, doctor.getCurrentConsultation("Need to review symptoms")));
                            doctor.consultationSetToNull();
                            System.out.println("Consultation added back to the queue for review.");
                        }
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }while ( option != 0);
    }

    private static void NurseDashboard(Nurse nurse, QueueManager queueManager, List<Consultation> consultationRecord, Inventory inventory) {
        int option;
        do {
            System.out.println("Nurse Dashboard for Nurse " + nurse.getFullName());
            System.out.println("What would you like to do?");
            System.out.println("1. Create a Queue Ticket for a Patient");
            System.out.println("2. Update Inventory from Consultation Usage");
            System.out.println("3. Make an Order to a Supplier");
            System.out.println("4. Call Supplier to Confirm Order");
            System.out.println("0. Exit Dashboard");
            System.out.print("Option: ");
            option = sc.nextInt();
            sc.nextLine(); // Consume the newline character

            switch (option) {
                case 1:
                    System.out.print("Enter Patient first name: ");
                    String patientFirstName = sc.nextLine();
                    System.out.print("Enter Patient last name: ");
                    String patientLastName = sc.nextLine();
                    System.out.print("Enter Patient middle initial: ");
                    String patientMiddleInitial = sc.nextLine();
                    System.out.print("Enter Patient gender: ");
                    String patientGender = sc.nextLine();
                    System.out.print("Enter Patient address: ");
                    String patientAddress = sc.nextLine();
                    System.out.print("Enter Patient Birthdate: ");
                    String patientBirthdate = sc.nextLine();
                    System.out.print("Enter current date (YYYY-MM-DD): ");
                    String currentDate = sc.nextLine();

                    Patient patient = new Patient(patientFirstName, patientLastName, patientMiddleInitial, patientGender, patientAddress, patientBirthdate);
                    Consultation consultation = new Consultation(patient, Integer.toString(new Random().nextInt(1000)), currentDate);

                    String symptom = "";
                    while(true) {
                        if(symptom.equalsIgnoreCase("done")) {
                            break;
                        }
                        System.out.println("Enter consultation symptoms (type 'done' when finished):");
                        symptom = sc.nextLine();
                        consultation.addSymptom(symptom);
                    }

                    
                    System.out.println("Enter preferred doctor specialty:");
                    String doctorSpecialtyPreferred = sc.nextLine();
                    nurse.createQueueTicket(Integer.toString(new Random().nextInt(1000)), doctorSpecialtyPreferred, consultation, queueManager);
                    System.out.println("Queue ticket created and added to the queue.");
                    break;
                case 2:
                    while(true){
                        UsageLog currentUsageLog = usageLogs.poll();
                        if(currentUsageLog == null) {
                            System.out.println("No usage logs to process.");
                            break;
                        }

                        currentUsageLog.displayLog();
                        Map<Item, Integer> usage = new HashMap<>();
                        inventory.displayAvailableItems();
                        

                    }
                    nurse.updateInventoryFromUsage(usage, inventory);
                    System.out.println("Inventory updated based on consultation usage.");
                    break;
                case 3:
                    System.out.println("Enter supplier name:");
                    String supplierName = sc.nextLine();
                    Supplier supplier = new Supplier(supplierName);
                    Map<String, Integer> itemsToOrder = new HashMap<>();
                    while(true) {
                        System.out.println("Enter the name of the item to order (or 'done' to finish):");
                        String itemName = sc.nextLine();
                        if(itemName.equalsIgnoreCase("done")) {
                            break;
                        }
                        System.out.println("Enter the quantity to order:");
                        int quantity = sc.nextInt();
                        sc.nextLine(); // Consume the newline character
                        itemsToOrder.put(itemName, quantity);
                    }
                    nurse.makeOrder(supplier, itemsToOrder);
                    System.out.println("Order placed with supplier.");
                    break;
                case 4:
                    System.out.println("Enter supplier name to call:");
                    String supplierToCall = sc.nextLine();
                    Supplier supplierObj = new Supplier(supplierToCall);
                    nurse.callSupplier(supplierObj, inventory);
                    System.out.println("Called supplier to confirm order and updated inventory accordingly.");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }

        }while ( option != 0);
    }

    private static Doctor createDoctorAccount() {
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


    private static void displayUserList() {
        System.out.println("Registered Users:");
        for(User user : users) {
            System.out.println("- " + user.getFullName() + " (" + user.getClass().getSimpleName() + ")");
        }
    }

    private static Inventory initializeInventory() {
        // Implementation for initializing inventory with items
        List<Item> availableItems = List.of(
            new Item(new Random().nextInt(1000), "Bandage", "A strip of material used to bind a wound or to protect an injured part of the body."),
            new Item(new Random().nextInt(1000), "Syringe", "A device used to inject fluids into or withdraw them from something."),
            new Item(new Random().nextInt(1000), "Stethoscope", "An instrument used by medical professionals to listen to the internal sounds of a patient's body."),
            new Item(new Random().nextInt(1000), "Thermometer", "An instrument for measuring and indicating temperature."),
            new Item(new Random().nextInt(1000), "Gloves", "Protective hand coverings used in medical settings to prevent contamination."),
            new Item(new Random().nextInt(1000), "Paracetamol", "A pain reliever and fever reducer."),
            new Item(new Random().nextInt(1000), "Antibiotic Ointment", "A topical medication used to prevent infection in minor cuts, scrapes, and burns."),
            new Item(new Random().nextInt(1000), "IV Drip", "A medical device used to deliver fluids, medication, or nutrients directly into a patient's bloodstream."),
            new Item(new Random().nextInt(1000), "Anti-Allergy Medication", "A drug used to treat allergic reactions and symptoms."),
            new Item(new Random().nextInt(1000), "", "A device used to measure blood pressure.")
        );  
        return new Inventory(availableItems);
    }
}