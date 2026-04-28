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
}