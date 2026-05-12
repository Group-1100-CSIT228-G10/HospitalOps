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
    }

    public void displayItem() {
        System.out.println("ID: " + itemID);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
        System.out.println("Quantity: " + quantity);
    }

    public void addStock(int amount) {  
        quantity += amount;
        System.out.println(amount + " added. New quantity: " + quantity);
    }

    public void reduceStock(int amount) {
        if (quantity >= amount) {
            quantity -= amount;
            System.out.println(amount + " removed. New quantity: " + quantity);
        } else {
            System.out.println("Not enough stock.");
        }
    }

    public boolean isAvailable() {
        return quantity > 0;
    }
}