package utilities;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import model.Service;
import model.User;

public class DataLoader {
    static List<Service> loadServiceData(String fileName){
        List<Service> services = new LinkedList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                services.add((Service)obj);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return services;
    }
    static Map<String, User> loadUserData(String fileName){
        HashMap<String, User> userData = new HashMap<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            Object obj;
            while ((obj = ois.readObject()) != null) {
                User user = (User)obj;
                userData.put(user.getId(), user);
            }
        } catch (EOFException e) {
            // End of file reached
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userData;
    }
}
