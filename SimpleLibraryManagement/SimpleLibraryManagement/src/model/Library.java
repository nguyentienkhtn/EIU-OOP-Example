package model;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Library {
    private ArrayList<Service> services;
    
    private ArrayList<User> users;
    public Library() {
        services = new ArrayList<>();
        
        users = new ArrayList<>();
        
    }

    public void addUser(User user){
        users.add(user);
    }

    public boolean containsUser(User user){
        return users.contains(user);
    }
    public void addService(Service s)
    {
        services.add(s);
    }

    public void removeService(Service s){
        
        services.remove(s);
    }

    
    public ArrayList<Service> getServices() {
        return services;
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public ArrayList<Service> search(String keyword){
        ArrayList<Service> result = new ArrayList<>();
        for (Service s : services) {
            if(s.toString().toLowerCase().contains(keyword.toLowerCase()))
                result.add(s);
        }
        return result;
    }

    

    public boolean bookService(User user, Service s, int loanPeriodDays){
        if (!s.isAvailable()) {
            return false;
        }
        s.setDueDate(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(loanPeriodDays)));
        s.setIsAvailable(false);
        user.addBookedService(s);
        return true;
       
        
    }

    public void returnService(User user, Service s){
        s.setIsAvailable(true);
        user.removeBookedService(s);;
    }

    public ArrayList<Service> getOverdueService(User user){
        ArrayList<Service> result = new ArrayList<>();
        for (Service s : user.getBookedServices()) {
            if(s.getDueDate().compareTo(new Date()) < 0)
                result.add(s);
        }
        return result;
    }

    public void loadUsersFromFile(String fileName){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    User user = (User) in.readObject();
                    users.add(user);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } 
        catch(ClassNotFoundException c){
            
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loadServicesFromFile(String fileName){
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    Service service = (Service) in.readObject();
                    services.add(service);
                } catch (EOFException e) {
                    break; // End of file reached
                }
            }
        } 
        catch(ClassNotFoundException c){

        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    



        
}
