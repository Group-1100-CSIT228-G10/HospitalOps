package Consultation_Logs;

public class UsageLog {

    private String itemName;
    private int quantity;

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

    public String toString() {
        return itemName + " - " + quantity;
    }
}