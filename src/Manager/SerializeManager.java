package Manager;

import User.*;
import java.io.*;
import java.util.*;

public class SerializeManager {
    public static final String SESSION_PATH = "src/Data/Users.ser";

    public static void serializeUser(List<User> user) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(SESSION_PATH))) {
            oos.writeObject(user);
            oos.flush();
            oos.close();
            System.out.println("Session saved locally.");
        } catch (IOException e) {
            System.err.println("Failed to serialize user: " + e.getMessage());
        }
    }

    public static List<User> deserializeUser() {
        File file = new File(SESSION_PATH);
        if (!file.exists()) {
            return null;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            System.out.println("User returned is NOT NULL");
            return (List<User>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Failed to deserialize user: " + e.getMessage());
            return null;
        }
    }

    public static void clearSession() {
        File file = new File(SESSION_PATH);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Session file deleted. User logged out.");
            }
        }
    }
}