import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import model.Book;
import model.Library;
import model.Room;
import model.User;

public class LibraryTest {
    Library bLibrary;
    User user;
    Book book;
    Room room;
    @Before
    public void setup(){
        
    }
    @Test
    public void testAddBook() {
        
        bLibrary.addBook(book);
    }

    @Test
    public void testAddRoom(){
        
        bLibrary.addRom(room);
    }

    @Test
    public void testAddUser() {
        
        bLibrary.addUser(user);
    }

    @Test
    public void testBookRoom() {
        testAddRoom();
        testAddUser();
        assertTrue(bLibrary.bookRoom(user, "203"));
        assertFalse(bLibrary.bookRoom(user, "213"));
        assertFalse(bLibrary.bookRoom(user, "203"));
        assertEquals(user.getBookedRooms().get(0).getId(), "203");        
    }

    @Test
    public void testBorrowBook() {

    }

    @Test
    public void testGetOverdueBooks() {

    }

    @Test
    public void testRemoveBook() {

    }

    @Test
    public void testReturnBook() {

    }

    @Test
    public void testReturnRoom() {

    }

    @Test
    public void testSearchBook() {

    }

    @Test
    public void testSearchRooms() {

    }
}
