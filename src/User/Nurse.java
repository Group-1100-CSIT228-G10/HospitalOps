package User;

import Inventory.*;
import Consultation_Logs.UsageLog;

public class Nurse extends User {

    private String department;
    private Inventory inventory;

    public Nurse(String userID, String firstName, String lastName,
                 String middleName, String gender, String city,
                 String country, String birthDate, int age,
                 String department, Inventory inventory) {

        super(userID, firstName, lastName, middleName, gender, city, country, birthDate, age);
        this.department = department;
        this.inventory = inventory;
    }

    public void updateInventoryFromUsage(UsageLog log, Item item) {
        if (!log.processed) {
            StockTransaction transaction = new StockTransaction(item, log.getQuantity(), StockTransaction.TransactionType.OUT);
            inventory.addTransaction(transaction);
            log.markProcessed();
        }
    }

    public String getDepartment() {
        return department;
    }
}