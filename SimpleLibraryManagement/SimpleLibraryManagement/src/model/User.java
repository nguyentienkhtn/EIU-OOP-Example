package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import utilities.PasswordUtil;

public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private String id;
    private String name;
    private String hashedPassword;
    private List<Service> bookedServices;
    
    public User(String id) {
        this.id = id;
        bookedServices = new ArrayList<>();
    }

    public User(String id, String name) {
        this.id = id;
        this.name = name;
        bookedServices = new ArrayList<>();
    }
    
    public void setPassword(String password) {
        this.hashedPassword = PasswordUtil.hashPassword(password);
    }
    
    
    public String getHashedPassword() {
        return hashedPassword;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addBookedService(Service service)
    {
        bookedServices.add(service);
    }

    public void removeBookedService(Service s)
    {
        bookedServices.remove(s);
    }
    

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof User))
            return false;
        else{
            User user = (User)obj;
            return (this.getId().equals(user.getId())) && (this.hashedPassword.equals(user.hashedPassword));
        }
    }

    public List<Service> getBookedServices() {
        return bookedServices;
    }

    
    
    
}
