package Inventory;

public class Supplier {

    public int supplierID;
    public String name;
    public String contactInfo;

    public Supplier(int supplierID, String name, String contactInfo) {
        this.supplierID = supplierID;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public void displaySupplier() {
        System.out.println("Supplier ID: " + supplierID);
        System.out.println("Name: " + name);
        System.out.println("Contact: " + contactInfo);
    }
}