package model;

public class PrintedBook extends Book{
    private int copyID;
    public PrintedBook(String isbn, String title, String author, int copyID) {
        super(isbn, title, author);
        this.copyID = copyID;
        super.setIsAvailable(true);
    }
    @Override
    public String toString() {
        return getClass().getSimpleName() + ", isbn: " + getIsbn() + ", title: " + getTitle().toUpperCase() + ", author: " + getAuthor() + ", copyid: " +copyID + ", isAvailable: " + isAvailable;
    }
    
    public int getCopyID() {
        return copyID;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof PrintedBook))
            return false;
        else{
            PrintedBook pBook = (PrintedBook)obj;
            return (this.getIsbn().equals(pBook.getIsbn())) && (this.getCopyID() == pBook.getCopyID());
        }
    }
    
    
    
    
    
    
}
