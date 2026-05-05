package Consultation_Logs;

public class UsageLog {

    private String itemName;
    private int quantity;
    private boolean processed = false;

    public UsageLog() {}

    public UsageLog(String itemName, int quantity) {
        this.itemName = itemName;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public boolean isProcessed() {
        return processed;
    }

    public void markProcessed() {
        this.processed = true;
    }

    public String toString() {
        return itemName + " - " + quantity;
    }
}