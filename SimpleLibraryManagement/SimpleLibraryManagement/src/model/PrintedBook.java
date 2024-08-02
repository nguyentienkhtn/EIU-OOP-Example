package model;

public class PrintedBook extends Book{
    private static final long serialVersionUID = 1L;
    private boolean isAvailable;
    private int copyID;
    public PrintedBook(String isbn, String title, String author, int copyID) {
        super(isbn, title, author);
        this.copyID = copyID;
        isAvailable = true;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ", isbn: " + getIsbn() + ", title: " + getTitle().toUpperCase() + ", author: " + getAuthor() + ", copyid: " +copyID + ", isAvailable: " + isAvailable;
    }
    
    public int getCopyID() {
        return copyID;
    }
    @Override
    public boolean isAvailable() {
        return isAvailable;
    }
    @Override
    public void setIsAvailable(boolean value) {
        isAvailable = value;
    }
    @Override
    public void setDueDate() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDueDate'");
    }
    
    
    
    
}
