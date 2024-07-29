import java.util.Date;

public abstract class Book {
    private String isbn;
    private String title;
    private String author;
    private int copyID;
    private boolean isBorrowed;
    private Date dueDate;
    
    public Book(String isbn, String title, String author, int copyID) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.copyID = copyID;
        this.isBorrowed = false;
        
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public int getCopyID() {
        return copyID;
    }
    public void setCopyID(int copyID) {
        this.copyID = copyID;
    }
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    
    
}
