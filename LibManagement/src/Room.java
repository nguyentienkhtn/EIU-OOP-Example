public class Room {
    private String id;
    private String description;
    private int capacity;
    private boolean isBooked;
    
    public Room(String id, String description, int capacity) {
        this.id = id;
        this.description = description;
        this.capacity = capacity;
        this.isBooked = false;
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
    public boolean isBooked() {
        return isBooked;
    }
    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }
    
}
