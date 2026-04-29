package Inventory;

public class Item {
    public String name;
    public String description;
    public int quantity;
    
    public Item(String name, String description, int quantity) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }
}