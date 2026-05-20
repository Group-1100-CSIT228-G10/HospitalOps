package User;

import Consultation_Logs.*;
import Inventory.*;
import QueueMngr.*;
import java.util.*;

public class Nurse extends User {



    public Nurse(String userID, String password, String firstName, String lastName,
                 String middleName, String gender, String city,
                 String country, String birthDate, int age) {

        super(userID, password, firstName, lastName, middleName, gender, city, country, birthDate, age);

    }

    
    //should be the one to create queue tickets for patients and assign them to doctors
    //should also be able to update the inventory when doctors add items to usage logs during consultations
   
    public void createQueueTicket(String ticketID, String doctorSpecialtyPreferred, Consultation consultation, QueueManager queueManager) {
        QueueTicket ticket = new QueueTicket(ticketID, doctorSpecialtyPreferred, consultation);
        queueManager.addToQueue(ticket);
        return;
    }
    
    public void updateInventoryFromUsage(Map<Item, Integer> usage, Inventory inventory) {
        for (Map.Entry<Item, Integer> entry : usage.entrySet()) {
            Item item = entry.getKey();
            int quantity = entry.getValue();
            inventory.takeStock(Map.of(item, quantity));
        }
    }

    public void makeOrder(Supplier supplier, Map<String, Integer> items) {
        Order order = new Order("ORD" + new Random().nextInt(1000), items);
        supplier.pendingOrders.add(order);
    }

    public void callSupplier(String supplierContact, Inventory inventory) {
        List<StockTransaction> transactions = supplier.callToConfirm();
        for (StockTransaction transaction : transactions) {
            inventory.addStock(transaction.getItems());
        }
    }


    // public void updateInventoryFromUsage(UsageLog log, Item item) {
    //     if (!log.processed) {
    //         StockTransaction transaction = new StockTransaction(item, log.getQuantity(), StockTransaction.TransactionType.OUT);
    //         inventory.addTransaction(transaction);
    //         log.markProcessed();
    //     }
    // }


}