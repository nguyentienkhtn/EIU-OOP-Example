package model;

import java.util.Date;

public class Room implements Service{
    private String id;
    private String description;
    private int capacity;
    private boolean isAvailable;
    
    public Room(String id, String description, int capacity) {
        this.id = id;
        this.description = description;
        this.capacity = capacity;
        this.isAvailable = true;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public int getCapacity() {
        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Override
    public boolean isAvailable() {
        return isAvailable;
    }
    @Override
    public void setIsAvailable(boolean value) {
        this.isAvailable = value;
    }
    @Override
    public Date getDueDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDueDate'");
    }
    @Override
    public void setDueDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDueDate'");
    }
    
    
}
