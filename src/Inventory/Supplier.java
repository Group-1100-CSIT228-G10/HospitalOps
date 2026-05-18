package Inventory;

import java.util.*;

public class Supplier {

    public int supplierID;
    public String name;
    public String contactInfo;
    public Queue<StockTransaction> pendingTransactions;

    public Supplier(int supplierID, String name, String contactInfo) {
        this.supplierID = supplierID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.pendingTransactions = new LinkedList<>();
    }

    public void processPendingTransactions() {
        while (!pendingTransactions.isEmpty()) {
            StockTransaction transaction = pendingTransactions.poll();
            transaction.applyTransaction();
            System.out.println("Processed transaction ID: " + transaction.transactionID);
        }
    }

    public void displaySupplier() {
        System.out.println("Supplier ID: " + supplierID);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contactInfo);
    }
}