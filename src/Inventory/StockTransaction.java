package Inventory;

public class StockTransaction {
    public String name;
    public String description;
    public int quantity;
    
    public StockTransaction(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }
}