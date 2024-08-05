package model;


public class Room extends Service{
    private String id;
    private String description;
    private int capacity;
    
    
    
    public Room(String id, String description, int capacity) {
        this.id = id;
        this.description = description;
        this.capacity = capacity;
        
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
    public boolean equals(Object obj) {
        if(!(obj instanceof Room))
            return false;
        else{
            Room room = (Room)obj;
            return (this.getId().equals(room.getId()));
        }
    }
    
    
    
}
