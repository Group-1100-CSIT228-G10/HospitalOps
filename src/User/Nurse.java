package User;

import Inventory.*;
import Consultation_Logs.UsageLog;

public class Nurse extends User {



    public Nurse(String userID, String firstName, String lastName,
                 String middleName, String gender, String city,
                 String country, String birthDate, int age) {

        super(userID, firstName, lastName, middleName, gender, city, country, birthDate, age);

    }

    
    //should be the one to create queue tickets for patients and assign them to doctors
    //should also be able to update the inventory when doctors add items to usage logs during consultations
    
    
    


    // public void updateInventoryFromUsage(UsageLog log, Item item) {
    //     if (!log.processed) {
    //         StockTransaction transaction = new StockTransaction(item, log.getQuantity(), StockTransaction.TransactionType.OUT);
    //         inventory.addTransaction(transaction);
    //         log.markProcessed();
    //     }
    // }


}