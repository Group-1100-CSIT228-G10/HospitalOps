package Inventory;

import java.util.*;

public class Order {
    private String orderId;
    private Map<String, Integer> items;

    public Order(String orderId, Map<String, Integer> items) {
        this.orderId = orderId;
        this.items = items;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            System.out.println("Item: " + entry.getKey() + ", Quantity: " + entry.getValue());
        }
    }
}