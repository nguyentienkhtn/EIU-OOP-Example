package model;
import java.util.ArrayList;

public class User {
    private String id;
    private String name;
    private String password;
    private ArrayList<Book> borrowedBooks;
    private ArrayList<Room> bookedRooms;
    public User(String id, String name) {
        this.id = id;
        this.name = name;
        bookedRooms = new ArrayList<>();
        borrowedBooks = new ArrayList<>();
    }
    
    public void setPassword(String password) {
        this.password = password;
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
    

    
    
}
