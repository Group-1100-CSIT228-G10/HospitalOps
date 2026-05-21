package Inventory;

import java.util.*;

public class Inventory {

    private Map<Item, Integer> stock;
    private List<Item> AvailableItems;
    // private Queue<StockTransaction> transactionQueue;

    public Inventory(List<Item> availableItems) {
        this.stock = new HashMap<>();
        this.AvailableItems = availableItems;
        initializeStock();
    }

    public void displayStock() {
        System.out.println("Current Inventory:");
        for (Map.Entry<Item, Integer> entry : stock.entrySet()) {
            System.out.println("- " + entry.getKey().name + ": " + entry.getValue());
        }
    }

    public void addStock(Map<Item, Integer> itemsToAdd) {
        if(itemsToAdd == null || itemsToAdd.isEmpty()) {
            System.out.println("No items to add.");
            return;
        }

        for (Map.Entry<Item, Integer> entry : itemsToAdd.entrySet()) {
            Item item = entry.getKey();
            int amount = entry.getValue();
            for (Item i : AvailableItems) {
                if (i.name.equalsIgnoreCase(item.name)) {
                    stock.put(i, stock.getOrDefault(i, 0) + amount);
                    break;
                }
            }
        }
    }

    public void takeStock(Map<Item, Integer> itemsToTake) {
        if(itemsToTake == null || itemsToTake.isEmpty()) {
            System.out.println("No items to take.");
            return;
        }

        for (Map.Entry<Item, Integer> entry : itemsToTake.entrySet()) {
            Item item = entry.getKey();
            int amount = entry.getValue();
            for (Item i : AvailableItems) {
                if (i.name.equalsIgnoreCase(item.name)) {
                    int currentQuantity = stock.getOrDefault(i, 0);
                    if (currentQuantity >= amount) {
                        stock.put(i, currentQuantity - amount);
                    } else {
                        System.out.println("Not enough stock for item: " + i.name);
                    }
                    break;
                }
            }
        }
    }

    public Map<Item, Integer> getStock(String reason) {
        if(reason.equals("admin")) {
            return stock;
        } else {
            System.out.println("Access Denied: Insufficient Permissions");
            return new HashMap<>();
        }
    }

    public List<Item> getAvailableItems(String reason) {
        if(reason.equals("admin")) {
            return AvailableItems;
        } else {
            System.out.println("Access Denied: Insufficient Permissions");
            return new ArrayList<>();
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available Items:");
        int i = 1;
        for (Item item : AvailableItems) {
            System.out.println(i + ". " + item.name);
            i++;
        }
    }

    private void initializeStock() {
        for (Item item : AvailableItems) {
            stock.put(item, 10);
        }
    }
}



