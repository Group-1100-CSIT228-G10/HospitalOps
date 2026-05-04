package Order;

public class Order {
    public String orderId;
    public String itemName;
    public int quantity;
    public String status;

    public Order(String orderId, String itemName, int quantity, String status) {
        this.orderId = orderId;
        this.itemName = itemName;
        this.quantity = quantity;
        this.status = status;
    }

    public void displayOrder() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Status: " + status);
    }

    public void updateStatus(String newStatus) {
        this.status = newStatus;
    }

    public boolean isCompleted() {
        return status.equalsIgnoreCase("Completed");
    }
        
    public void processOrder() {
        System.out.println("Processing order " + orderId + "...");
        status = "Processing";
    }
}