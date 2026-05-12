package Consultation_Logs;

import java.util.*;
import Inventory.*;

public class UsageLog {

    private ArrayList<Item> logList;
    private String logName;
    public boolean processed;

    public UsageLog(String logName) {
        this.logName = logName;
        logList = new ArrayList<>();
        processed = false;
    }

    public boolean addItem(Item item) {
        if (item.isAvailable()) {
            logList.add(item);
            return true;
        } else {
            System.out.println("Item " + item.name + " is not available.");
            return false;
        }
    }

    public void displayLog() {
        System.out.println("Usage Log: " + logName);
        for (Item item : logList) {
            System.out.println("- " + item.name);
        }
    }

    public void markProcessed() {
        this.processed = true;
    }
}