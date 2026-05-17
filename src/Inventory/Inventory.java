package Inventory;

import java.util.*;

public class Inventory {

    private Map<Item, Integer> stock;
    private List<Item> AvailableItems;
    // private Queue<StockTransaction> transactionQueue;

    public Inventory(List<Item> availableItems) {
        this.stock = new HashMap<>();
        this.AvailableItems = availableItems;
    }

    public void displayStock() {
        System.out.println("Current Inventory:");
        for (Map.Entry<Item, Integer> entry : stock.entrySet()) {
            System.out.println("- " + entry.getKey().name + ": " + entry.getValue());
        }
    }

    public void addStock(String item, int amount) {
        for(Item i : AvailableItems) {
            if (i.name.equalsIgnoreCase(item)) {
                stock.put(i, stock.getOrDefault(i, 0) + amount);
                return;
            }
        }
        System.out.println("Item not available.");
    }

    public void removeStock(String item, int amount) {
        for(Item i : AvailableItems) {
            if (i.name.equalsIgnoreCase(item)) {
                int currentQuantity = stock.getOrDefault(i, 0);
                if (currentQuantity >= amount) {
                    stock.put(i, currentQuantity - amount);
                } else {
                    System.out.println("Not enough stock.");
                }
                return;
            }
        }
        System.out.println("Item not available.");
    }
}

