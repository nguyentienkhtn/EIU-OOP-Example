package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{
    private String id;
    private String name;
    private String hashedPassword;
    private ArrayList<Book> borrowedBooks;
    private ArrayList<Room> bookedRooms;
    private List<Service> bookedService;
    public User(String id, String name) {
        this.id = id;
        this.name = name;
        bookedRooms = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
        bookedService = new ArrayList<>();
    }
    
    public void setPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
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
    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }
    
    public ArrayList<Room> getBookedRooms() {
        return bookedRooms;
    }
    
    public void addBorrowedBook(Book book){
        borrowedBooks.add(book);
    }
    public void removedBorrowedBook(Book book){
        borrowedBooks.remove(book);
    }
    public void addBookedRoom(Room room){
        bookedRooms.add(room);
    }
    public void removedBookedRoom(Room room){
        bookedRooms.remove(room);
    }
    public void addBookedService(Service service)
    {
        bookedService.add(service);
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + "]";
    }
    
    
    
}
