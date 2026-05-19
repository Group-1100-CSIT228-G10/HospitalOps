
import java.util.*;
import User.*;
import Inventory.*;
import Consultation_Logs.*;
import QueueMngr.*; 

public class HospitalOps {
    public static void EngineStart() {
        Scanner sc = new Scanner(System.in);    
        // Create some items
        Item bandage = new Item(new Random().nextInt(1000),"Bandage", "A sterile bandage for wound care.");
        Item syringe = new Item(new Random().nextInt(1000),"Syringe", "A medical syringe for injections.");
        Item stethoscope = new Item(new Random().nextInt(1000),"Stethoscope", "A device used to listen to heart and lung sounds.");

        // Create inventory with available items
        Inventory inventory = new Inventory(List.of(bandage, syringe, stethoscope));

        // Create a supplier
        Supplier supplier = new Supplier(new Random().nextInt(1000),"MedSupply Co.", "09694112013", List.of(bandage, syringe, stethoscope));

        // Create a nurse
        Nurse nurse = new Nurse("N001", "sixseven", "Alice", "Smith", "M.", "Female", "New York", "USA", "1985-05-15", 39);
        // Create an admin
        Admin admin = new Admin("A001", "adminpass", "John", "Doe", "P.", "Male", "Los Angeles", "USA", "1980-10-10", 44);
    }










    private static void createDoctorAccount() {
        Scanner sc = new Scanner(System.in);
        // Implementation for creating a doctor account
    }

    private static void createNurseAccount() {
        Scanner sc = new Scanner(System.in);
        // Implementation for creating a nurse account
    }

    private static void createAdminAccount() {
        Scanner sc = new Scanner(System.in);
        // Implementation for creating an admin account
    }
}