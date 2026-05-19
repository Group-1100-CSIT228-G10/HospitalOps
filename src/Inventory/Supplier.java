package Inventory;

import java.util.*;

public class Supplier {

    public int supplierID;
    public String name;
    public String contactInfo;
    public Queue<Order> pendingOrders;
    public List<Item> availableItems;

    public Supplier(int supplierID, String name, String contactInfo, List<Item> availableItems) {
        this.supplierID = supplierID;
        this.name = name;
        this.contactInfo = contactInfo;
        this.pendingOrders = new LinkedList<>();
        this.availableItems = availableItems;
    }

    public List<StockTransaction> callToConfirm(){
        if(pendingOrders.isEmpty()) {
            System.out.println("No pending orders for supplier: " + name);
            return Collections.emptyList();
        }
        return processPendingOrders();
    }

    public void displaySupplier() {
        System.out.println("Supplier ID: " + supplierID);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contactInfo);
    }

    public void addAvailableItem(Item item) {
        if (!availableItems.contains(item)) {
            availableItems.add(item);
        }else {
            System.out.println("Item already available from this supplier.");
        }
    }

    private List<StockTransaction> processPendingOrders() {
        List<StockTransaction> transactions = new ArrayList<>();
        while (!pendingOrders.isEmpty()) {
            Order order = pendingOrders.poll();
            Map<Item, Integer> orderItems = new HashMap<>();
            for(Map.Entry<String, Integer> entry : order.getItems().entrySet()) {
                String itemName = entry.getKey();
                int quantity = entry.getValue();
                for (Item item : availableItems) {
                    if (item.name.equalsIgnoreCase(itemName)) {
                        orderItems.put(item, quantity);
                        break;
                    }
                }
            }
            StockTransaction transaction = new StockTransaction( new Random().nextInt(1000), orderItems, new Date());
            transactions.add(transaction);
        }
        return transactions;
    }

}