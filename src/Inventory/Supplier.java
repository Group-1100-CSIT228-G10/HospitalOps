package Inventory;

import java.util.*;

public class Supplier {

    public int supplierID;
    public String name;
    public String contactInfo;
    public Queue<Order> pendingOrders;

    public Supplier(int supplierID, String name, String contactInfo) {
        this.supplierID = supplierID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.pendingOrders = new LinkedList<>();
    }

    public List<StockTransaction> processPendingOrders() {
        List<StockTransaction> transactions = new ArrayList<>();
        while (!pendingOrders.isEmpty()) {
            Order order = pendingOrders.poll();
            System.out.println("Processing order from supplier " + name + ":");
            order.displayOrder();
        }
        return transactions;
    }

    public void displaySupplier() {
        System.out.println("Supplier ID: " + supplierID);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contactInfo);
    }
}