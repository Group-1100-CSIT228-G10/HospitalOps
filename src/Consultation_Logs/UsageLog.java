package Consultation_Logs;

import java.util.*;
import Inventory.*;

public class UsageLog {

    private String logName;
    private ArrayList<Item> logList;
    public boolean processed;

    public UsageLog(String logName) {
        this.logName = logName;
        logList = new ArrayList<>();
        processed = false;
    }

    public boolean addItem(Item item) {  
        if (!processed) {
            logList.add(item);
            return true;
        }else{
            System.out.println("Cannot add item. Log has already been processed.");
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