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

    public void removeBook(String isbn, int copyID){
        for (Book book : books) {
            if(book.getIsbn().equals(isbn) && book.getCopyID()==copyID)
                books.remove(book);
        }
    }

    public Book searchBook(String isbn){
        for (Book book : books) {
            if(book.getIsbn().equals(isbn) && !!book.isBorrowed())
                return book;
        }
        return null;
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

    public boolean borrowBook(User user, String isbn, int loanPeriodDays){
        Book search = searchBook(isbn);
        if(search != null){
            search.setDueDate(new Date(System.currentTimeMillis() + TimeUnit.DAYS.toMillis(loanPeriodDays)));
            search.setBorrowed(true);
            user.addBorrowedBook(search);
            return true;
        } 
        return false;
    }

    public void returnBook(User user, String isbn, int copyID){
        for (int i = 0; i < books.size(); i++) {
            if(books.get(i).getCopyID() == copyID && 
                books.get(i).getIsbn().equals(isbn)){
                    books.get(i).setBorrowed(false);
                    user.removedBorrowedBook(books.get(i));
                }
        }
    }

    public boolean bookRoom(User user, String roomID){
        Room bookedRoom = null;
        for (Room room : rooms) {
            if(room.getId().equals(roomID))
                bookedRoom = room;
        }
        if(bookedRoom == null && bookedRoom.isBooked())
            return false;
        else{
            bookedRoom.setBooked(true);
            user.addBookedRoom(bookedRoom);
            return true;
        }
    }

    public void returnRoom(User user, String roomID){
        for (int i = 0; i < rooms.size(); i++) {
            Room temp = rooms.get(i);
            if(temp.getId().equals(roomID)){
                user.removedBookedRoom(temp);
                temp.setBooked(false);
            }
        }
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
