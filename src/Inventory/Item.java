package Inventory;

import GUI.AppState;

public class Item {
    public int itemID;
    public String name;
    public String description;

    public Item(int itemID, String name, String description) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;
    }

    @Override
    public String toString() {
        int stock = AppState.get().stock.getOrDefault(name, 0);
        return name + " (stock: " + stock + ")";
    }

    public void displayItem() {
        System.out.println("ID: " + itemID);
        System.out.println("Name: " + name);
        System.out.println("Description: " + description);
    }

}