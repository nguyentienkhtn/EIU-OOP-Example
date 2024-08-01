package model;
import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Library {
    private ArrayList<Book> books;
    private ArrayList<Room> rooms;
    private ArrayList<User> users;
    public Library() {
        books = new ArrayList<>();
        rooms = new ArrayList<>();
        users = new ArrayList<>();
        
    }

    public void addUser(User user){
        users.add(user);
    }

    public void addBook(Book book)
    {
        books.add(book);
    }

    public void addRom(Room room){
        rooms.add(room);
    }

    public void removeBook(Book book){
        
        books.remove(book);
    }

    public ArrayList<Book> search(String keyword){
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if(book.toString().contains(keyword))
                result.add(book);
        }
        return result;
    }

    public ArrayList<Room> searchRooms(String infor){
        ArrayList<Room> result = new ArrayList<>();
        for (Room room : rooms) {
            if(room.getId().equals(infor) ||
                room.getDescription().contains(infor))
                result.add(room);
        }
        return result;
    }

    public boolean borrowBook(User user, Book book, int loanPeriodDays){
        if (book.isBorrowed()) {
            return false;
        }
        book.setDueDate(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(loanPeriodDays)));
        book.setBorrowed(true);
        user.addBorrowedBook(book);
        return true;
       
        
    }

    public void returnBook(User user, Book book){
        user.removedBorrowedBook(book);
        book.setBorrowed(false);
    }
    
    public boolean bookRoom(User user, String roomID){
        Room bookedRoom = null;
        for (Room room : rooms) {
            if(room.getId().equals(roomID))
                bookedRoom = room;
        }
        if(bookedRoom == null || bookedRoom.isBooked())
            return false;
        else{
            bookedRoom.setBooked(true);
            user.addBookedRoom(bookedRoom);
            return true;
        }
    }

    public void returnRoom(User user, Room room){
        room.setBooked(false);
        user.removedBookedRoom(room);
    }

    public ArrayList<Book> getOverdueBooks(){
        ArrayList<Book> result = new ArrayList<>();
        for (Book book : books) {
            if(book.getDueDate().compareTo(new Date()) < 0)
                result.add(book);
        }
        return result;
    }



        
}
