package Inventory;

public class Item {
    public int itemID;
    public String name;
    public String description;
    public int quantity;

    public Item(int itemID, String name, String description, int quantity) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
        this.quantity = quantity;
    }
}