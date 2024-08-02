package model;
import java.io.Serializable;
import java.util.Date;

public abstract class Book implements Serializable, Service{
    private static final long serialVersionUID = 1L;
    private String isbn;
    private String title;
    private String author;
    private Date dueDate;
    
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        
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
    
    
    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
    
    public abstract String toString();
    
    
    
    
}
