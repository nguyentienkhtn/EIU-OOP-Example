package model;

public class PrintedBook extends Book{
    private boolean isBorrowed;
    private int copyID;
    public PrintedBook(String isbn, String title, String author, int copyID) {
        super(isbn, title, author);
        this.copyID = copyID;
        isBorrowed = false;
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + " " + "isbn: " + getIsbn() + " title: " + getTitle() + " author: " + getAuthor() + " copyid: " +copyID + "isborrowed: " + isBorrowed;
    }
    @Override
    public void setBorrowed(boolean isBorrowed) {
        this.isBorrowed = isBorrowed;
    }
    @Override
    public boolean isBorrowed() {
        return isBorrowed;
    }
    public int getCopyID() {
        return copyID;
    }
    
    
    
    
}
