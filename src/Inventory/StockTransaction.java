package Inventory;

import java.util.Date;

public class StockTransaction {

    public enum TransactionType {
        IN, OUT
    }

    private Item item;
    private int quantity;
    private TransactionType type;
    private Date date;

    public StockTransaction(Item item, int quantity, TransactionType type) {
        this.item = item;
        this.quantity = quantity;
        this.type = type;
        this.date = new Date();
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public TransactionType getType() {
        return type;
    }

    public Date getDate() {
        return date;
    }

    public String toString() {
        return type + " - " + item.name + " - " + quantity;
    }
}