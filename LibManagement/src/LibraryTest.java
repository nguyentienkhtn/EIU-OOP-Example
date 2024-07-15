import org.junit.Before;
import org.junit.Test;

public class LibraryTest {
    Library bLibrary;
    @Before
    public void setup(){
        bLibrary = new Library();
    }
    @Test
    public void testAddBook() {
        Book book = new Book("123456", "Introduction to java", "Tony", 1);
        bLibrary.addBook(book);
    }

    @Test
    public void testAddRoom(){
        Room room = new Room("203", "Study room with TV", 10);
    }

    @Test
    public void testAddUser() {

    }

    @Test
    public void testBookRoom() {

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
