package Inventory;

import java.util.LinkedList;
import java.util.Queue;

public class Inventory {

    private Item item;
    private int quantity;
    private Queue<StockTransaction> transactionQueue;

    public Inventory(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
        this.transactionQueue = new LinkedList<>();
    }

    public void addTransaction(StockTransaction transaction) {
        transactionQueue.add(transaction);

        if (transaction.getType() == StockTransaction.TransactionType.IN) {
            quantity += transaction.getQuantity();
        } else {
            quantity -= transaction.getQuantity();
        }
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public Queue<StockTransaction> getTransactionQueue() {
        return transactionQueue;
    }
}