package Inventory;

public class StockTransaction {

    private int transactionID;
    private String type; 
    private int quantityChanged;
    private Date date;
    private Item item;

    public StockTransaction(int transactionID, String type, int quantityChanged, Item item, Date date) {
        this.transactionID = transactionID;
        this.type = type;
        this.quantityChanged = quantityChanged;
        this.item = item;
        this.date = date;
    }

    public void applyTransaction() {
        if (type.equalsIgnoreCase("IN")) {
            item.addStock(quantityChanged);
        } else if (type.equalsIgnoreCase("OUT")) {
            item.reduceStock(quantityChanged);
        } else {
            System.out.println("Invalid transaction type!");
        }
    }

    public void displayTransaction() {
        System.out.println("Transaction ID: " + transactionID);
        System.out.println("Type: " + type);
        System.out.println("Quantity: " + quantityChanged);
        System.out.println("Date: " + date);
        System.out.println("Item: " + item.name);
    }
}