package Inventory;

import java.util.*;

public class StockTransaction {

    private int transactionID;
    private Map<Item, Integer> items;
    private Date date;

    public StockTransaction(int transactionID, Map<Item, Integer> items, Date date) {
        this.transactionID = transactionID;
        this.items = items;
        this.date = date;
    }
    

    // public void applyTransaction() {
    //     if (type.equalsIgnoreCase("IN")) {
    //         item.addStock(quantityChanged);
    //     } else if (type.equalsIgnoreCase("OUT")) {
    //         item.reduceStock(quantityChanged);
    //     } else {
    //         System.out.println("Invalid transaction type!");
    //     }
    // }

    // public int getTransactionID() {return transactionID;}
    // public void displayTransaction() {  
    //     System.out.println("Transaction ID: " + transactionID);
    //     System.out.println("Type: " + type);
    //     System.out.println("Quantity: " + quantityChanged);
    //     System.out.println("Date: " + date);
    //     System.out.println("Item: " + item.name);
    // }
}